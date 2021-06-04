package com.airline.reservations.reservation;

import javax.persistence.*;

@Entity
@Table
public class Reservation {
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

    private long reserve_id;
    private String name;
    private String flight_no;

    public Reservation() {
    }

    public Reservation(long reserve_id, String name, String flight_no) {
        this.reserve_id = reserve_id;
        this.name = name;
        this.flight_no = flight_no;
    }

    public Reservation(String name, String flight_no) {
        this.name = name;
        this.flight_no = flight_no;
    }

    public long getReserve_id() {
        return reserve_id;
    }

    public void setReserve_id(long reserve_id) {
        this.reserve_id = reserve_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reserve_id=" + reserve_id +
                ", name='" + name + '\'' +
                ", flight_no='" + flight_no + '\'' +
                '}';
    }
}
