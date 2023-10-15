package com.risorlet.ATM_Simulator;

import java.sql.*;

public class DatabaseConnection {
    
    String url = "jdbc:mysql://localhost/atm_simulator";
    String userName = "root";
    String password = "root@2801";

    Connection conn;
    Statement st;

    DatabaseConnection(){

        try {
            // Loads the JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creates a connection between the driver and the database
            conn = DriverManager.getConnection(url, userName, password);

            // Creates a statement which will be used to execute queries
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
