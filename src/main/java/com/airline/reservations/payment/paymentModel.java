package com.airline.reservations.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class paymentModel {
    private final paymentRepository paymentRepository;

    @Autowired
    public paymentModel(com.airline.reservations.payment.paymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void addpayment(Long reserveid, Long custid, Long cc){
        payment newpayment = new payment(reserveid, custid, cc);
        paymentRepository.save(newpayment);
    }
}
