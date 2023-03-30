package com.example.service;

import com.example.model.CreditCard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.util.DBUtil;
import com.example.model.Trip;

public class TripService {

    public TripService() {
    }
    
    public List<Trip> getTripsByCustomerId(int customerId) throws SQLException {
        List<Trip> trips = new ArrayList<Trip>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get connection
            connection = DBUtil.getConnection();

            // create prepared statement
            statement = connection.prepareStatement("SELECT * FROM trips WHERE customer_id = ?");

            // set parameters
            statement.setInt(1, customerId);

            // execute query
            resultSet = statement.executeQuery();

            // process result set
            while (resultSet.next()) {
                Trip trip = new Trip();
                trip.setId(resultSet.getInt("id"));
                trip.setDestination(resultSet.getString("destination"));
                trip.setStartDate(resultSet.getDate("start_date"));
                trip.setEndDate(resultSet.getDate("end_date"));
                trip.setPrice(resultSet.getDouble("price"));

                trips.add(trip);
            }

            return trips;

        } catch (SQLException e) {
            throw e;
        } finally {
            // close resources
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
    
    public double calculatePrice(CreditCard card, Trip trip) {
        return trip.getPrice();
    }
}