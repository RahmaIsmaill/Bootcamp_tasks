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
        String sql = "INSERT INTO users (firstname, lastname, email, dob, city) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = databaseOperations.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setDate(4, new java.sql.Date(user.getDob().getTime()));
            pstmt.setString(5, user.getCity());

            pstmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to save user: " + e.getMessage());
        }
    }
}
