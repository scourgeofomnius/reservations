package com.airline.reservations.flight;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private LocalDateTime dept_time;
    private LocalDateTime arrival_time;

    public String getDep_time() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
        return dept_time.format(formatter);
    }

    public void setDept_time(LocalDateTime dep_time) {
        this.dept_time = dep_time;
    }

    public String getArrival_time() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
        return arrival_time.format(formatter);
    }

    public void setArrival_time(LocalDateTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public flight(String destination, String origin, String flight_no) {
        this.destination = destination;
        this.origin = origin;
        this.flight_no = flight_no;
    }

    public flight(String destination, String origin, String flight_no, LocalDateTime dep_time, LocalDateTime arrival_time) {
        this.destination = destination;
        this.origin = origin;
        this.flight_no = flight_no;
        this.dept_time = dep_time;
        this.arrival_time = arrival_time;
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
                ", dep_time=" + dept_time +
                ", arrival_time=" + arrival_time +
                '}';
    }

    public String getFlight_no() {
        return flight_no;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }
}
