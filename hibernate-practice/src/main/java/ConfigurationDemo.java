import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigurationDemo {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        // Load Hibernate configuration
        configuration.configure("hibernate.cfg.xml");

        // Register entity classes
        configuration.addAnnotatedClass(Laptop.class);
        configuration.addAnnotatedClass(Student.class);

        // Build SessionFactory
        SessionFactory sessionFactory =
                configuration.buildSessionFactory();

        // Open and close a Session
        try (Session session = sessionFactory.openSession()) {

            System.out.println("Hibernate configuration successful.");
            System.out.println("Session opened successfully.");

        } finally {

            sessionFactory.close();
            System.out.println("SessionFactory closed.");
        }
    }
}