package com.vehiclesSystem.dao;

import com.vehiclesSystem.config.DatabaseConfig;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BikeDAO implements VehicleDAO {

    @Autowired
    private DatabaseConfig databaseConfig;

    @Override
    public void saveVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (type, brand) VALUES (?, ?)";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            Bike bike = (Bike) vehicle;
            pstmt.setString(1, bike.getType().name());
            pstmt.setString(2, bike.getBrand());
            pstmt.executeUpdate();
            System.out.println("Bike saved successfully");
        } catch (SQLException e) {
            System.out.println("Failed to save bike: " + e.getMessage());
        }
    }

    @Override
    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicle WHERE id = ?";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Bike deleted successfully: " + id);
            } else {
                System.out.println("No bike found with id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete bike: " + e.getMessage());
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicle SET type = ?, brand = ? WHERE id = ?";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            Bike bike = (Bike) vehicle;
            pstmt.setString(1, bike.getType().name());
            pstmt.setString(2, bike.getBrand());
            pstmt.setInt(3, Integer.parseInt(bike.getId()));
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Bike updated successfully");
            } else {
                System.out.println("No bike found with id: " + bike.getId());
            }
        } catch (SQLException e) {
            System.out.println("Failed to update bike: " + e.getMessage());
        }
    }

    @Override
    public Vehicle searchById(int id) {
        String sql = "SELECT * FROM vehicle WHERE id = ?";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Bike bike = new Bike();
                bike.setId(String.valueOf(rs.getInt("id")));
                bike.setType(Type.valueOf(rs.getString("type")));
                bike.setBrand(rs.getString("brand"));
                return bike;
            }
        } catch (SQLException e) {
            System.out.println("Failed to find bike: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void getAllVehicles() {
        String sql = "SELECT * FROM vehicle";

        try (Connection connection = databaseConfig.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean found = false;
            while (rs.next()) {
                String id = rs.getString("id");
                String brand = rs.getString("brand");
                String type = rs.getString("type");

                System.out.println("ID: " + id + ", Brand: " + brand + ", Type: " + type);
                found = true;
            }

            if (!found) {
                System.out.println("No planes found in database.");
            }

        } catch (SQLException e) {
            System.out.println("Failed to get vehicles: " + e.getMessage());
        }
    }
}
