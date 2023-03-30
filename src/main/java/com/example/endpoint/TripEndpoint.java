package com.example.endpoint;

import com.example.model.CreditCard;
import com.example.model.Trip;
import com.example.service.TripService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class TripEndpoint {
    
    private TripService tripService;
    
    public TripEndpoint() {
        tripService = new TripService();
    }

    @WebMethod(operationName = "calculatePrice")
    public double calculatePrice(@WebParam(name = "cardHolderName") String cardHolderName,
                                 @WebParam(name = "cardType") String cardType,
                                 @WebParam(name = "cardNumber") String cardNumber,
                                 @WebParam(name = "cardCVC") String cardCVC,
                                 @WebParam(name = "cardExpDate") String cardExpDate,
                                 @WebParam(name = "destination") String destination,
                                 @WebParam(name = "startDate") String startDate,
                                 @WebParam(name = "endDate") String endDate) {
        CreditCard card = new CreditCard(cardHolderName, cardType, cardNumber, cardCVC, cardExpDate);
        Trip trip = new Trip(destination, startDate, endDate);
        return tripService.calculatePrice(card, trip);
    }
}