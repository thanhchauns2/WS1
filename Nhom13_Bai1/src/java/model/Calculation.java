/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Calculation {
    public static double calculateFee(double basePrice, int numberOfTravelers, boolean usePromoCode, Card card) {
        double totalFee = basePrice * numberOfTravelers;
        
        // Apply promo code discount
        if (usePromoCode) {
            totalFee *= 0.9; // 10% discount
        }
        
        // Add credit card fee
        double creditCardFee = 0.0;
        switch (card.getCardType()) {
            case "Visa":
                creditCardFee = 0.02;
                break;
            case "MasterCard":
                creditCardFee = 0.025;
                break;
            default:
                creditCardFee = 0.03;
        }
        totalFee += totalFee * creditCardFee;
        
        return totalFee;
    }
}