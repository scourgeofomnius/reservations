package com.airline.reservations.flight;

import javax.persistence.*;

@Entity
@Table
public class flight {
    @Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName = "flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flight_sequence"
    )

    private long id;
    private String destination;
    private String origin;
    private String flight_no;

    public flight(String destination, String origin, String flight_no) {
        this.destination = destination;
        this.origin = origin;
        this.flight_no = flight_no;
    }

    public flight() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "flight{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                ", flight_no='" + flight_no + '\'' +
                '}';
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }
}
