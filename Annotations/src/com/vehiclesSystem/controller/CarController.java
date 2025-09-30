package com.vehiclesSystem.controller;

import com.vehiclesSystem.config.AppConfig;
import com.vehiclesSystem.config.DatabaseConfig;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
import com.vehiclesSystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarController implements VehicleController{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CarService carService = context.getBean("carService", CarService.class);

        Vehicle car = new Car("1", "Toyota", Type.CAR);
        carService.saveVehicle(car);
        carService.deleteVehicle(2);
        carService.updateVehicle(new Car("1", "BMW", Type.CAR));
        carService.searchById(5);
        carService.getAllVehicles();

        context.close();
    }

}
