package com.airline.reservations.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class flightModel {
    private final com.airline.reservations.flight.flightRepository flightRepository;
    private String flight_no;

    @Autowired
    public flightModel(com.airline.reservations.flight.flightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<flight> getFlight() {
        return flightRepository.findAll();
    }

    public List<flight> findbydestandarrival(String dest, String origin){
        return flightRepository.findByDestinationAndAndOrigin(dest, origin);
    }

    public List<flight> findbydest(String dest) {
        return flightRepository.findByDestination(dest);
    }


    public List<String> getdestinations(){
        return flightRepository.getdestinations();
    }

    public List<String> getorigins(){
        return flightRepository.getorigins();
    }


    public List<flight> findByFlightno(String flightno){
        return flightRepository.findByFlightno(flightno);
    }

    public flight getByFlightno(String flightno){ return flightRepository.getByFlightno(flightno);}


}