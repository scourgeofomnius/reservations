package com.airline.reservations.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path="/api/v1/flight")
public class flightController {
    public final flightModel flightModel;

    @Autowired
    public flightController(com.airline.reservations.flight.flightModel flightModel) {
        this.flightModel = flightModel;
    }


    @GetMapping("/searchflight")
    public List<flight> getFlight(){
        return flightModel.getFlight();
    }

//    @PostMapping("/searchflight")
//    public String searchflights(String dest, String origin){
//        List<flight> flights = flightModel.findbydestandarrival(dest, origin);
//        System.out.println(dest);
//        System.out.println(origin);
//        //return new ModelAndView("searchflight", ) ;
//        return "none";
//    }

    @PostMapping("/searchflights")
    public @ResponseBody List<flight> getflightById(@RequestBody Search dest)
    {
        List<flight> flights = flightModel.findbydest(dest.getSearch_text());
        return flights;
    }


}