import com.example.model.Passport;
import com.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchAll {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Query<Person> query = session.createQuery("from Person", Person.class);

            List<Person> list = query.getResultList();

            //List of all Person
            System.out.println("List of all Person:");
            for (Person product : list) {
                System.out.println(product);
            }



            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
