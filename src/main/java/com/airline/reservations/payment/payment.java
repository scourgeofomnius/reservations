package com.airline.reservations.payment;

import org.jetbrains.annotations.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;

@Entity
@Table
public class payment {
    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )

    private long paymentid;
    private long reserveid;
    private long custid;

    @NotNull
    @Size(min=16, max=16)
    private String cc;

    public payment(long reserveid, long custid, String cc) {
        this.reserveid = 1;
        this.custid = 2;
        this.cc = cc;
    }

    public payment() {

    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public long getReserveid() {
        return reserveid;
    }

    public void setReserveid(long reserveid) {
        this.reserveid = reserveid;
    }

    public long getCustid() {
        return custid;
    }

    public void setCustid(long custid) {
        this.custid = custid;
    }

}