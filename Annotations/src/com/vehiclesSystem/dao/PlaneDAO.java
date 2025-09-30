package com.vehiclesSystem.dao;

import com.vehiclesSystem.config.DatabaseConfig;
import com.vehiclesSystem.models.Plane;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class PlaneDAO implements VehicleDAO {

    @Autowired
    private DatabaseConfig databaseConfig;

    @Override
    public void saveVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (type, brand) VALUES (?, ?)";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            Plane plane = (Plane) vehicle;
            pstmt.setString(1, plane.getType().name());
            pstmt.setString(2, plane.getBrand());
            pstmt.executeUpdate();
            System.out.println("Plane saved successfully");
        } catch (SQLException e) {
            System.out.println("Failed to save plane: " + e.getMessage());
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
                System.out.println("Plane deleted successfully: " + id);
            } else {
                System.out.println("No plane found with id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete plane: " + e.getMessage());
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicle SET type = ?, brand = ? WHERE id = ?";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            Plane plane = (Plane) vehicle;
            pstmt.setString(1, plane.getType().name());
            pstmt.setString(2, plane.getBrand());
            pstmt.setInt(3, Integer.parseInt(plane.getId()));
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Plane updated successfully");
            } else {
                System.out.println("No plane found with id: " + plane.getId());
            }
        } catch (SQLException e) {
            System.out.println("Failed to update plane: " + e.getMessage());
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
                Plane plane = new Plane();
                plane.setId(String.valueOf(rs.getInt("id")));
                plane.setType(Type.valueOf(rs.getString("type")));
                plane.setBrand(rs.getString("brand"));
                return plane;
            }
        } catch (SQLException e) {
            System.out.println("Failed to find plane: " + e.getMessage());
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
