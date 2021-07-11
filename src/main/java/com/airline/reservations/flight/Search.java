package com.airline.reservations.flight;

public class Search {

    private String destination;
    private String origin;
    private String selected;

    public Search() {
    }

    public Search(String search_text) {
        this.destination = search_text;
    }

    public Search(String destination, String origin, String selected) {
        this.destination = destination;
        this.origin = origin;
        this.selected =selected;
    }


    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
