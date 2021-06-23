package com.airline.reservations.flight;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.airline.reservations.reservations.Reservations;

import java.util.List;

@Controller
public class flightController {
    public final flightModel flightModel;

    @Autowired
    public flightController(com.airline.reservations.flight.flightModel flightModel) {
        this.flightModel = flightModel;
    }


    @RequestMapping("/searchflight")
    //@ResponseBody
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
    public String returnsearch(@ModelAttribute Search search, Model model){
        List<flight> flights = flightModel.findbydestandarrival(search.getDestination(),
                search.getOrigin());
        model.addAttribute("searchlist", flights);
        model.addAttribute("search", new Search());
        return "searchresult";
    }

    @PostMapping("/book")
    public String book(@ModelAttribute Search search, Model model){
        model.addAttribute("search", search);
        model.addAttribute("reservation", new Reservations());
        //model.addAttribute("flight", flight);
        return "book";
    }

}