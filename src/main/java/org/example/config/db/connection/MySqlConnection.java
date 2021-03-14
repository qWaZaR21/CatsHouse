package org.example.config.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class MySqlConnection {

    public static final String URL = "jdbc:mysql://localhost:3306/db_example";
    public static final String USERNAME = "paku";
    public static final String PASSWORD = "123qwe!@#QWE";

    public MySqlConnection() {

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
