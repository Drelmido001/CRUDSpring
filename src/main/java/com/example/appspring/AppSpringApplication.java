package com.example.appspring;

import com.example.appspring.datasource.DataBaseConnection;
import com.example.appspring.repository.repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@RestController
public class AppSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSpringApplication.class, args);
    }

}
