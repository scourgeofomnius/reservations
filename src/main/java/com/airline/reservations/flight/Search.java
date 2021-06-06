package com.airline.reservations.flight;

public class Search {
    private String search_text;

    public Search() {
    }

    public Search(String search_text) {
        this.search_text = search_text;
    }

    public String getSearch_text() {
        return search_text;
    }

    public void setSearch_text(String search_text) {
        this.search_text = search_text;
    }
}
