
package com.ioc.example;

public class Rectangle implements shape {
    public Rectangle() {
    }

    public void getArea(double width) {
        double area = width * width;
        System.out.println("The area of the Rectangle: " + area);
    }
}
