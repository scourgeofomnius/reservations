package com.airline.reservations.reservations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {

    List<Reservations> getReservationsByCustid(String custid);

    List<Reservations> getReservationsByName(String name);

    void deleteByNameAndAndFlightno(String name, String flightno);
}
