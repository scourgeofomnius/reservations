package com.airline.reservations.payment;

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
    private long cc;

    public payment(long reserveid, long custid, long cc) {
        this.reserveid = reserveid;
        this.custid = custid;
        this.cc = cc;
    }

    public payment() {

    }

    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
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

    //public
}