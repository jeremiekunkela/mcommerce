package com.mpaiement.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PaymentImpossibleException extends RuntimeException {


    public PaymentImpossibleException(String message) {
        super(message);
    }
}
