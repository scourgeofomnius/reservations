package com.airline.reservations.flight;


import com.airline.reservations.payment.paymentModel;
import com.airline.reservations.reservations.Reservations;
import com.airline.reservations.reservations.ReservationsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class flightController {
    public final flightModel flightModel;
    public final ReservationsModel reservationsModel;
    public final paymentModel paymentModel;

    @Autowired
    public flightController(com.airline.reservations.flight.flightModel flightModel, ReservationsModel reservationsModel, com.airline.reservations.payment.paymentModel paymentModel) {
        this.flightModel = flightModel;
        this.reservationsModel = reservationsModel;
        this.paymentModel = paymentModel;
    }

    @RequestMapping("/searchflight")
    public String searchflight(Model model){
        List<String> destinations = flightModel.getdestinations();
        List<String> origins = flightModel.getorigins();
        model.addAttribute("search", new Search());
        model.addAttribute("destinations", destinations);
        model.addAttribute("origins", origins);
        return "searchflight";

    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/searchflight")
    public String returnsearch(@ModelAttribute Search search, Model model, Principal principal){
        List<flight> flights = flightModel.findbydestandarrival(search.getDestination(),
                search.getOrigin());
        model.addAttribute("searchlist", flights);
        model.addAttribute("search", new Search());
        model.addAttribute("pricipal", principal);
        return "searchresult";
    }

    @RequestMapping("/status")
    public String returnstatus(@ModelAttribute Search search, Model model, Authentication authentication) throws Exception {
        String name = authentication.getName();
        List<Reservations> reservationsList = reservationsModel.getReservationbyUser(name);
        List<flight> flights = new ArrayList<>();
        reservationsList.forEach((reserve) ->{
          flights.add(flightModel.getByFlightno(reserve.getFlightno()));
        });

        model.addAttribute("flights", flights);
        model.addAttribute("search", new Search());
        return "status";
    }


}