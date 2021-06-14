package com.airline.reservations.flight;

import com.airline.reservations.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface flightRepository extends JpaRepository<flight, Long> {

    List<flight> findByDestinationAndAndOrigin(String dest, String origin);

    List<flight> findByDestination(String dest);

    @Query(value = "select distinct flight.destination from flight", nativeQuery = true)
    List<String> getdestinations();

    @Query(value = "select distinct flight.origin from flight", nativeQuery = true)
    List<String> getorigins();
}
