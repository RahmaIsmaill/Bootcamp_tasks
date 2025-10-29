package com.example.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AggregationFunctionsOnProducts {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Products.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Query<Products> query = session.createQuery("select  avg (price) from Products ");
            List<Products> list = query.getResultList();
            System.out.println("Average price of all products: " + list);


           query = session.createQuery("select  sum (price) from Products ");
            list = query.getResultList();
            System.out.println("Sum of all products: " + list);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
