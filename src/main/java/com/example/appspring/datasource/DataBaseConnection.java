package com.example.appspring.datasource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/dbcv";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    @Bean
    public static Connection connection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC introuvable", e);
        }
    }
    }


