package com.airline.reservations.reservations;

import com.airline.reservations.flight.Search;
import com.airline.reservations.flight.flight;
import com.airline.reservations.flight.flightModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
//@RequestMapping(path="api/v1/reservation")
public class ReserverationsController {

    private final ReservationsModel reservationsModel;
    private final flightModel flightModel;

    @Autowired
    public ReserverationsController(ReservationsModel reservationsModel, com.airline.reservations.flight.flightModel flightModel) {
        this.reservationsModel = reservationsModel;
        this.flightModel = flightModel;
    }

    @PostMapping("/cancel")
    @Transactional
    public String cancelflight(@ModelAttribute Search search, Model model, Authentication authentication){
        String name = authentication.getName();
        String flight = search.getSelected();
        flight bookedflight = flightModel.getByFlightno(flight);
        boolean isdeleted = false;
        model.addAttribute("search", search);
        model.addAttribute("flight", bookedflight);
        reservationsModel.deleteByNameAndFlightno(name, flight);

        return "cancel";

        //return "status";
    }


}
