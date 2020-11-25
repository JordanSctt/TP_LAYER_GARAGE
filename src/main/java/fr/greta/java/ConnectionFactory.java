package fr.greta.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final static String URL = "jdbc:postgresql://localhost/garage";
    private final static String USER = "postgres";
    private final static String PASSWORD = "admin";

    public Connection create() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
