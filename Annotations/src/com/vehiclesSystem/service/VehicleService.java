package com.vehiclesSystem.service;

import com.vehiclesSystem.models.Vehicle;



public interface VehicleService {
    void saveVehicle(Vehicle vehicle);

    void deleteVehicle(int id);

    void updateVehicle(Vehicle vehicle);

    void searchById(int id);

    void getAllVehicles();
}
