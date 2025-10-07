package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Vehicle;

public interface VehicleDAO {
    void saveVehicle(Vehicle vehicle);

    void deleteVehicle(int id);

    void updateVehicle(Vehicle vehicle);

    Vehicle searchById(int id);

    void getAllVehicles();
}
