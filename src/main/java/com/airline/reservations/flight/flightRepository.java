package com.airline.reservations.flight;

import com.airline.reservations.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface flightRepository extends JpaRepository<flight, Long> {

}
