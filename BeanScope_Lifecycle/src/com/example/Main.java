package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("======Same reference using singleton======");
        Circle circle1 =container.getBean("circle", Circle.class);
        System.out.println(circle1);

        Circle circle2 = container.getBean("circle", Circle.class);
        System.out.println(circle2);
        System.out.println();
        System.out.println("======Different reference using prototype======");
        Square square1 = container.getBean("square", Square.class);
        System.out.println(square1);

        Square square2 = container.getBean("square", Square.class);
        System.out.println(square2);

        DatabaseOperations databaseOperations = container.getBean("databaseOperations", DatabaseOperations.class);
        ((ClassPathXmlApplicationContext)container).close();
    }
}