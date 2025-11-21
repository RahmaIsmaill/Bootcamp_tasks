package com.example.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchSomeProducts {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Query<Person> query = session.createQuery("from Person ", Person.class);
           query.setMaxResults(5);
           query.setFirstResult(0);


            List<Person> list = query.getResultList();


            for (Person product : list) {
                System.out.println(product);
            }



            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
