package com.vehiclesSystem.service;
import com.vehiclesSystem.dao.PlaneDAO;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PlaneService implements VehicleService {
    @Autowired
    private PlaneDAO planeDAO;

    @Override
    public void saveVehicle(Vehicle vehicle) {
        planeDAO.saveVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(int id) {
        planeDAO.deleteVehicle(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        planeDAO.updateVehicle(vehicle);
    }

    @Override
    public void searchById(int id) {
        planeDAO.searchById(id);
    }

    @Override
    public void getAllVehicles() {
        planeDAO.getAllVehicles();
    }
}
