package main.com.myApp.dao;

import main.com.myApp.config.DatabaseOperations;
import main.com.myApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class UserDao {

    @Autowired
    private DatabaseOperations databaseOperations;

    public void saveUser(User user) {
        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";

        try (Connection connection = databaseOperations.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());

            pstmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to save user: " + e.getMessage());
        }
    }
}
