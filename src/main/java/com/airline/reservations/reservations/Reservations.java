package com.airline.reservations.reservations;

import javax.persistence.*;

@Entity
@Table
public class Reservations {
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )

    private long reserveid;
    private String name;
    private String flightno;
    private String custid;

    public Reservations() {

    }


    public Reservations(String name, String flightno, String custid) {
        this.name = name;
        this.flightno = flightno;
        this.custid = custid;
    }

    public long getReserveid() {
        return reserveid;
    }

    public void setReserveid(long reserve_id) {
        this.reserveid = reserve_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flight_no) {
        this.flightno = flight_no;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reserve_id=" + reserveid +
                ", name='" + name + '\'' +
                ", flight_no='" + flightno + '\'' +
                '}';
    }
}
