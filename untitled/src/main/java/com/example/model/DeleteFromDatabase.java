package com.example.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteFromDatabase {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
       User user = session.get(User.class, 2);
       session.delete(user);
       session.getTransaction().commit();
        session.close();

    }
}
