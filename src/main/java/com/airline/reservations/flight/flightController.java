package com.airline.reservations.flight;

import com.airline.reservations.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/flight")
public class flightController {
    public final flightModel flightModel;

    @Autowired
    public flightController(com.airline.reservations.flight.flightModel flightModel) {
        this.flightModel = flightModel;
    }


    @GetMapping
    public List<flight> getFlight(){
        return flightModel.getFlight();
    }
}
