package com.airline.reservations.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("search", new Search());
        return "searchflight";
    }

    @PostMapping("/searchflight")
    public String returnsearch(@ModelAttribute Search search, Model model){
        List<flight> flights = flightModel.findbydestandarrival(search.getDestination(),
                search.getOrigin());
        model.addAttribute("searchlist", flights);
        return "searchresult";
    }


}