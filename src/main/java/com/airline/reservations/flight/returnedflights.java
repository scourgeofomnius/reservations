package com.airline.reservations.flight;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class returnedflights {

    public final flightModel flightModel;

    @Autowired
    public returnedflights(com.airline.reservations.flight.flightModel flightModel) {
        this.flightModel = flightModel;
    }

    public List<flight> getFlights(String dest, String origin) {
        return flightModel.findbydestandarrival(dest, origin);
    }

}
