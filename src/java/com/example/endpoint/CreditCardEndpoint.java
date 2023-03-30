package com.example.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.CreditCard;
import com.example.service.CreditCardService;

@WebService
public class CreditCardEndpoint {

    @Autowired
    private CreditCardService creditCardService;

    @WebMethod(operationName = "getCreditCard")
    @WebResult(name = "creditCard")
    public CreditCard getCreditCard(@WebParam(name = "cardNumber") String cardNumber) {
        return creditCardService.getCreditCardByNumber(cardNumber);
    }

    @WebMethod(operationName = "makePayment")
    @WebResult(name = "result")
    public boolean makePayment(@WebParam(name = "creditCard") CreditCard creditCard,
            @WebParam(name = "amount") double amount) {
        return creditCardService.makePayment(creditCard, amount);
    }
}