package com.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        // Load MySQL driver explicitly (optional for MySQL 8+)
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/storedb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        return DriverManager.getConnection(url, user, password);
    }
}
