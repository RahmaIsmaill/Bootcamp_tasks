import com.example.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchAllProducts {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Products.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Query<Products> query = session.createQuery("from Products", Products.class);

            List<Products> list = query.getResultList();

            //List of all products
            System.out.println("List of all products:");
            for (Products product : list) {
                System.out.println(product);
            }



            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
