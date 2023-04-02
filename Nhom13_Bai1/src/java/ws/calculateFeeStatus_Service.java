/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

import dao.CalculateDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "calculateFeeStatus_Service")
public class calculateFeeStatus_Service {

    @WebMethod(operationName = "calculateFee")
    public double calculateFee(
            @WebParam(name = "cardHolderName") String cardHolderName, 
            @WebParam(name = "cardType") String cardType, 
            @WebParam(name = "cardNumber") String cardNumber, 
            @WebParam(name = "cvcNumber") String cvcNumber, 
            @WebParam(name = "expMonth") int expMonth, 
            @WebParam(name = "expYear") int expYear, 
            @WebParam(name = "totalAmount") double totalAmount) {
        CalculateDAO dao = new CalculateDAO();
        boolean isValidCard = dao.isValidCard(cardHolderName, cardType, cardNumber, cvcNumber, expMonth, expYear);
        if (!isValidCard) {
            throw new IllegalArgumentException("Invalid credit card information.");
        }

        double fee = 0.0;
        if (totalAmount <= 1000) {
            fee = 10.0;
        } else if (totalAmount > 1000 && totalAmount <= 5000) {
            fee = 20.0;
        } else if (totalAmount > 5000 && totalAmount <= 10000) {
            fee = 30.0;
        } else {
            fee = 50.0;
        }

        return fee;
    }

}