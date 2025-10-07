package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.CarDAO;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CarService implements VehicleService {
    @Autowired
    private CarDAO carDAO;

    @Override
    public void saveVehicle(Vehicle vehicle) {
        carDAO.saveVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(int id) {
        carDAO.deleteVehicle(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        carDAO.updateVehicle(vehicle);
    }

    @Override
    public void searchById(int id) {
        carDAO.searchById(id);
    }

    @Override
    public void getAllVehicles() {
        carDAO.getAllVehicles();
    }
}
