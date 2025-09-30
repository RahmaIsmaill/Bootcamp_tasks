
package com.ioc.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        shape cicle = container.getBean("cicle", shape.class);
        cicle.getArea(3.0);
        shape Rectangle =container.getBean("rectangle", shape.class);
        Rectangle.getArea(3.0);
    }
}
