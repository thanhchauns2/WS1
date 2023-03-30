package com.example.service;

import com.example.model.CreditCard;
import com.example.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreditCardService {
    
    private Connection conn;
    
    public CreditCardService() {
        conn = DBUtil.getConnection();
    }
    
    public boolean checkCreditCard(String cardholderName, String cardType, String cardNumber, String cvc, String expiryDate) {
        boolean isValid = false;
        
        try {
            String sql = "SELECT * FROM credit_cards WHERE cardholder_name = ? AND card_type = ? AND card_number = ? AND cvc = ? AND expiry_date = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cardholderName);
            ps.setString(2, cardType);
            ps.setString(3, cardNumber);
            ps.setString(4, cvc);
            ps.setString(5, expiryDate);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isValid;
    }

    public CreditCard getCreditCardByNumber(String cardNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean makePayment(CreditCard creditCard, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}