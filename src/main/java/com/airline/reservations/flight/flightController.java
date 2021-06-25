package com.airline.reservations.flight;


import com.airline.reservations.reservations.ReservationsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class flightController {
    public final flightModel flightModel;
    public final ReservationsModel reservationsModel;

    @Autowired
    public flightController(com.airline.reservations.flight.flightModel flightModel, ReservationsModel reservationsModel) {
        this.flightModel = flightModel;
        this.reservationsModel = reservationsModel;
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

    @PostMapping("/book")
    public String book(@ModelAttribute Search search, Model model, Authentication authentication){
        List<flight> bookedflight = flightModel.findByFlightno(search.getSelected());
        reservationsModel.addreservation(authentication.getName(), search.getSelected());
        model.addAttribute("search", search);
        model.addAttribute("flight", bookedflight);
        return "book";
    }

}