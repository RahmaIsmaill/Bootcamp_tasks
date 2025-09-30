package com.vehiclesSystem.config;

import com.vehiclesSystem.models.Vehicle;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Scope("singleton")
@Getter
@Setter
public class DatabaseConfig {

    @Value("${database.url}")
    private String URL;

    @Value("${database.user}")
    private String USER;

    @Value("${database.password}")
    private String PASSWORD;

    private Connection connection;

    @PostConstruct
    public void connectToDatabase() {
        try {
            System.out.println("---------------Successfully connected to Database------------------");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(URL);
            System.out.println(USER);
            System.out.println(PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to establish connection: " + e.getMessage());
        }
    }

    @PreDestroy
    private void disconnectFromDatabase() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("---------------Successfully disconnected from Database------------------");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicle;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
