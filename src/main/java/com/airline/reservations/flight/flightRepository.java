package com.airline.reservations.flight;

import com.airline.reservations.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface flightRepository extends JpaRepository<flight, Long> {

    List<flight> findByDestinationAndAndOrigin(String dest, String origin);

    List<flight> findByDestination(String dest);
}
