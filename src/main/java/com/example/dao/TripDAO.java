package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Trip;
import com.example.util.DBUtil;

public class TripDAO {

    public Trip getTripById(int id) throws SQLException {
        Trip trip = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("SELECT * FROM trip WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                trip = new Trip();
                trip.setId(resultSet.getInt("id"));
                trip.setDestination(resultSet.getString("destination"));
                trip.setStartDate(resultSet.getDate("start_date"));
                trip.setEndDate(resultSet.getDate("end_date"));
                trip.setPrice(resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(statement);
            DBUtil.closeConnection(connection);
        }

        return trip;
    }

    public List<Trip> getTripsByCustomerId(int customerId) throws SQLException {
        List<Trip> trips = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("SELECT * FROM trip WHERE customer_id = ?");
            statement.setInt(1, customerId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trip trip = new Trip();
                trip.setId(resultSet.getInt("id"));
                trip.setDestination(resultSet.getString("destination"));
                trip.setStartDate(resultSet.getDate("start_date"));
                trip.setEndDate(resultSet.getDate("end_date"));
                trip.setPrice(resultSet.getDouble("price"));
                trips.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(statement);
            DBUtil.closeConnection(connection);
        }

        return trips;
    }

}