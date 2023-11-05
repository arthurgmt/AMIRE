package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {

    private static final String URL = "jdbc:postgresql://localhost:5432/app_db";
    private static final String USER = "testntmfdp";
    private static final String PASSWORD = "Masamune31";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
