package com.airline.reservations.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/reservation")
public class reserverationController {

    private final reservationModel reservationModel;

    @Autowired
    public reserverationController(com.airline.reservations.reservation.reservationModel reservationModel) {
        this.reservationModel = reservationModel;
    }


    @GetMapping
    public List<Reservation> getReservation(){
            return reservationModel.getReservation();
    }
}
