package com.vehiclesSystem.controller;

import com.vehiclesSystem.config.AppConfig;
import com.vehiclesSystem.config.DatabaseConfig;
import com.vehiclesSystem.models.Plane;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
import com.vehiclesSystem.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class PlaneController implements VehicleController {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        PlaneService planeService = context.getBean("planeService", PlaneService.class);

        Vehicle plane = new Plane("10", "Airbus", Type.PLANE);
        planeService.saveVehicle(plane);

        planeService.deleteVehicle(2);

        planeService.updateVehicle(new Plane("15", "Boeing", Type.PLANE));

        planeService.searchById(15);

        planeService.getAllVehicles();

        context.close();
    }


}
