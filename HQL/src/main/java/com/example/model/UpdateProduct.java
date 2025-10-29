package com.example.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateProduct {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Products.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Query query = session.createQuery("update Products set name = :n where product_id = :id");
            query.setParameter("n", "Laptop");
            query.setParameter("id", 1);

            int status = query.executeUpdate();
            System.out.println(status);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
