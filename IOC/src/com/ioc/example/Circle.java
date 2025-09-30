package com.ioc.example;

public class Circle implements shape {
    public Circle() {
    }

    public void getArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle: " + area);
    }
}
