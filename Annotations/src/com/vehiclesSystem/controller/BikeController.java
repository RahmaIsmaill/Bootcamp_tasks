package com.vehiclesSystem.controller;

import com.vehiclesSystem.config.AppConfig;
import com.vehiclesSystem.config.DatabaseConfig;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
import com.vehiclesSystem.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BikeController implements VehicleController{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BikeService bikeService = context.getBean("bikeService", BikeService.class);

        Vehicle car = new Bike("3", "Toyota", Type.BIKE);
        bikeService.saveVehicle(car);
        bikeService.deleteVehicle(2);
        bikeService.updateVehicle(new Bike("5", "BMW", Type.BIKE));
        bikeService.searchById(5);
        bikeService.getAllVehicles();

        context.close();
    }
}
