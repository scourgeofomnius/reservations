package com.airline.reservations.payment;

import com.airline.reservations.flight.Search;
import com.airline.reservations.flight.flight;
import com.airline.reservations.flight.flightModel;
import com.airline.reservations.reservations.ReservationsModel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class paymentController {
    public final com.airline.reservations.flight.flightModel flightModel;
    public final ReservationsModel reservationsModel;
    public final paymentModel paymentModel;

    public paymentController(com.airline.reservations.flight.flightModel flightModel, ReservationsModel reservationsModel, com.airline.reservations.payment.paymentModel paymentModel) {
        this.flightModel = flightModel;
        this.reservationsModel = reservationsModel;
        this.paymentModel = paymentModel;
    }
    public boolean validatepayment(String cc){

        return true;
    }

    @PostMapping("/book")
    public String book(@ModelAttribute Search search, Model model, payment payment, Authentication authentication){
        List<flight> bookedflight = flightModel.findByFlightno(search.getSelected());
        reservationsModel.addreservation(authentication.getName(), search.getSelected());
        model.addAttribute("search", search);
        model.addAttribute("flight", bookedflight);
        model.addAttribute("payment", payment);
        return "book";
    }

    @PostMapping("/paymt")
    public String book(@ModelAttribute Search search, Model model, Authentication authentication, payment payment){
        List<flight> bookedflight = flightModel.findByFlightno(search.getSelected());
        model.addAttribute("search", search);
        model.addAttribute("flight", bookedflight);
        model.addAttribute("payment", payment);
        return "paymt";
    }
}
