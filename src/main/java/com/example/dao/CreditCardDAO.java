package com.example.dao;

import com.example.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardDAO {
    private Connection connection;

    public CreditCardDAO() {
        connection = DBUtil.getConnection();
    }

    public boolean checkCreditCard(String cardName, String cardType, String cardNumber, String cardCVC, String cardExpire) {
        try {
            String query = "SELECT * FROM credit_card WHERE name = ? AND type = ? AND number = ? AND cvc = ? AND expire = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cardName);
            preparedStatement.setString(2, cardType);
            preparedStatement.setString(3, cardNumber);
            preparedStatement.setString(4, cardCVC);
            preparedStatement.setString(5, cardExpire);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}



