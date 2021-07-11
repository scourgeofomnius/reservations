package com.airline.reservations.reservations;

import com.airline.reservations.flight.Search;
import com.airline.reservations.flight.flightModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="api/v1/reservation")
public class ReserverationsController {

    private final ReservationsModel reservationsModel;
    private final flightModel flightModel;

    @Autowired
    public ReserverationsController(ReservationsModel reservationsModel, com.airline.reservations.flight.flightModel flightModel) {
        this.reservationsModel = reservationsModel;
        this.flightModel = flightModel;
    }

//
//    @GetMapping
//    public List<Reservations> getReservation(){
//            return reservationsModel.getReservation();
//    }
////
////    @RequestMapping("/book")
////        public String bookflight(Model model){
////            model.addAttribute("search", new Search());
////            return "searchflight";
////        }


}
