/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateDAO {
    private Connection connection;

    public CalculateDAO(Connection connection) {
        this.connection = connection;
    }

    public CalculateDAO() {

    }

    public double getBasePrice(int packageId) throws SQLException {
        double basePrice = 0.0;
        String query = "SELECT price FROM package WHERE package_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, packageId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                basePrice = rs.getDouble("price");
            }
        }
        return basePrice;
    }

    public boolean validatePromoCode(String promoCode) throws SQLException {
        boolean isValid = false;
        String query = "SELECT promo_code FROM promo WHERE promo_code = ? AND expire_date >= NOW()";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, promoCode);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
        }
        return isValid;
    }

    public boolean isValidCard(String cardHolderName, String cardType, String cardNumber, String cvcNumber, int expMonth, int expYear) {
        // Check card holder name
        if (cardHolderName == null || cardHolderName.trim().isEmpty()) {
            return false;
        }

        // Check card type
        if (!cardType.equals("Visa") && !cardType.equals("MasterCard") && !cardType.equals("AmericanExpress")) {
            return false;
        }

        // Check card number length
        if (cardNumber.length() != 16) {
            return false;
        }

        // Check CVC number length
        if (cvcNumber.length() != 3) {
            return false;
        }

        // Check expiration date
        int currentYear = java.time.Year.now().getValue();
        if (expYear < currentYear || (expYear == currentYear && expMonth < java.time.Month.from(java.time.LocalDate.now()).getValue())) {
            return false;
        }

        return true;
    }
}