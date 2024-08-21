package com.cuestionarios.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final static String url = "jdbc:mysql://localhost:3306/surveys";
    private final static String user = "root";
    private final static String password = "Lt*23";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
