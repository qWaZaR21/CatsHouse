package org.example;

import org.example.config.BeansConfig;
import org.example.config.db.DbWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.sql.*;

@Import(BeansConfig.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(Application.class, args);

        ResultSet resultSet = DbWorker.getInstance().executeSelectQuery("select * from persons;");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2));
        }

        resultSet.close();
    }

}