package task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Vehicle Car = container.getBean("car", Vehicle.class);
        Car.saveToDatabase("Car");
        System.out.println();
        Vehicle Plane = container.getBean("plane", Vehicle.class);
        Car.saveToDatabase("Plane");
    }
}
