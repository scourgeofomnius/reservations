package com.airline.reservations.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reservationModel {
    private final reservationRepository reservationRepository;

    @Autowired
    public reservationModel(com.airline.reservations.reservation.reservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservation(){
        return reservationRepository.findAll();
    }
}
