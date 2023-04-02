/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nhom13_bai1_client;

import ws.CalculateFeeStatusService;
import ws.CalculateFeeStatusService_Service;

/**
 *
 * @author Admin
 */
public class Nhom13_Bai1_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cardHolderName = "Nguyen Van A";
        String cardType = "Visa";
        String cardNumber = "4111111111111111";
        String cvcNumber = "123";
        int expMonth = 12;
        int expYear = 2024;
        double totalAmount = 15.0;
        String expirationDate = String.format("%02d%02d", expMonth, expYear % 100);

        CalculateFeeStatusService_Service calc = new CalculateFeeStatusService_Service();

        CalculateFeeStatusService calculator = calc.getCalculateFeeStatusServicePort();
        double res = calculator.calculateFee(cardHolderName, cardType, cardNumber, cvcNumber, expMonth, expYear, totalAmount);
        System.out.println(res);
    }
    
}
