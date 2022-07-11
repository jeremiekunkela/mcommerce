package com.mpaiement.web.controller;

import com.mpaiement.Service.PaymentService;
import com.mpaiement.model.Payment;
import com.mpaiement.web.exceptions.PaymentExistingException;
import com.mpaiement.web.exceptions.PaymentImpossibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @PostMapping(value = "/payment")
    public ResponseEntity<Payment>  payAnOrder(@RequestBody Payment payment){


        //Vérify if the payment is already done
        Payment paymentExisting = paymentService.verifyPayment(payment.getIdOrder());
        if(paymentExisting != null) throw new PaymentExistingException("Cette commande est déjà payée");

        //Save the payment
        Payment newPayement = paymentService.addPayment(payment);


        if(newPayement == null) throw new PaymentImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");



        //TODO Nous allons appeler le Microservice Commandes ici pour lui signifier que le paiement est accepté

        return new ResponseEntity<Payment>(newPayement, HttpStatus.CREATED);

    }




}
