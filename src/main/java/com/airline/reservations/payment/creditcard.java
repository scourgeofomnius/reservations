package com.airline.reservations.payment;

import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Size;

public class creditcard {

    @NotNull
    @Size(min = 16, max = 16)
    private String cc;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    private String date;

    @NotNull
    private String address;

    public creditcard(String cc, String name, String date, String address) {
        this.cc = cc;
        this.name = name;
        this.date = date;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public creditcard() {
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
