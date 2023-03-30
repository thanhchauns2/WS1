package com.example.model;

public class CreditCard {
    private String ownerName;
    private String cardType;
    private String cardNumber;
    private String cvc;
    private String expirationDate;

    public CreditCard() {
    }

    public CreditCard(String ownerName, String cardType, String cardNumber, String cvc, String expirationDate) {
        this.ownerName = ownerName;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expirationDate = expirationDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean validateCard() {
        // TODO: Validate credit card information here
        return true;
    }
}