package org.example.config.db;

import org.example.config.db.connection.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DbWorker {

    private Connection connection;
    private static DbWorker instance = null;

    private DbWorker(){
        try {
            connection = new MySqlConnection().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static DbWorker getInstance(){
        if (instance == null) {
            instance = new DbWorker();
        }
        return instance;
    }

    public void executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement stm = prepareStatement(query, params);
        stm.execute();
        stm.close();
    }

    public ResultSet executeSelectQuery(String query, Object... params) throws SQLException {
        PreparedStatement stm = prepareStatement(query, params);
        return stm.executeQuery();
    }

    private PreparedStatement prepareStatement(String query, Object... params) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof Integer) {
                stm.setInt(i + 1, (Integer) params[i]);
            } else {
                stm.setString(i + 1, (String) params[i]);
            }
        }
        return stm;
    }

    public Integer getDbId() throws SQLException {
        ResultSet resultSet = executeSelectQuery("select getDbId();");
        if (!resultSet.next()) {
            return null;
        }
        int id = resultSet.getInt(1);
        resultSet.close();
        return id;
    }
}
