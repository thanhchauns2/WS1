package com.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = "com.mysql.cj.jdbc.Driver";
                String serverName = "localhost";
                String portNumber = "3306";
                String dbName = "bai2_ws";
                String userID = "root";
                String password = "123456";
                String url = "jdbc:mysql://localhost:3306/bai1_ws";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, userID, password);
                return connection;
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
    
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                Statement statement = resultSet.getStatement();
                resultSet.close();
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing result set: " + e.getMessage());
            }
        }
    }
    
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.err.println("Error while closing statement: " + ex.getMessage());
            }
        }
    }
    
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}