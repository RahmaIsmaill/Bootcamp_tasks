package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.BikeDAO;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BikeService implements VehicleService {
    @Autowired
    private BikeDAO bikeDAO;

    @Override
    public void saveVehicle(Vehicle vehicle) {
        bikeDAO.saveVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(int id) {
        bikeDAO.deleteVehicle(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        bikeDAO.updateVehicle(vehicle);
    }

    @Override
    public void searchById(int id) {
        bikeDAO.searchById(id);
    }

    @Override
    public void getAllVehicles() {
        bikeDAO.getAllVehicles();
    }
}
