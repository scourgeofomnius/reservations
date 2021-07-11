package com.airline.reservations.reservations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsModel {
    private final ReservationsRepository reservationsRepository;

    @Autowired
    public ReservationsModel(com.airline.reservations.reservations.ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public List<Reservations> getReservation(){
        return reservationsRepository.findAll();
    }

    public void addreservation(String name, String selected){
        Reservations newreserve = new Reservations(name,selected,1);
        reservationsRepository.save(newreserve);
    }


}
