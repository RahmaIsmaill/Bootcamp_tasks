package main.com.myApp.config;

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
public class DatabaseOperations {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String user;

    @Value("${database.password}")
    private String password;

    private Connection connection;

    @PostConstruct
    public void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("--------------- Successfully connected to Database ------------------");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Failed to establish connection: " + e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    @PreDestroy
    private void disconnectFromDatabase() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("--------------- Successfully disconnected from Database ------------------");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }
}