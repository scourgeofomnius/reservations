package com.airline.reservations.flight;

import com.airline.reservations.reservation.Reservation;
import com.airline.reservations.reservation.reservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class flightModel {
    private final com.airline.reservations.flight.flightRepository flightRepository;

    @Autowired
    public flightModel(com.airline.reservations.flight.flightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<flight> getflight() {
        return flightRepository.findAll();
    }

    public List<flight> getFlight() {
        return flightRepository.findAll();
    }
}