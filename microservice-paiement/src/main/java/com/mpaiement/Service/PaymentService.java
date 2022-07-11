package com.mpaiement.Service;

import com.mpaiement.model.Payment;
import com.mpaiement.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public Payment verifyPayment(Integer idOrder) {
        return PaymentRepository.findByidOrder(idOrder);
        }
        public Payment addPayment(Payment payment) {
            paymentRepository.save(payment);
            return payment;
        }
    }


