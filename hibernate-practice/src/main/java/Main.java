import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        // Hibernate configuration
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Laptop.class);
        configuration.addAnnotatedClass(Student.class);

        // Create SessionFactory
        SessionFactory sessionFactory =
                configuration.buildSessionFactory();

        // Open Session
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        try {

            // Create entity objects
            Laptop l1 = new Laptop();
            l1.setL_id(101);
            l1.setRam(16);
            l1.setBrand("Apple");

            Laptop l2 = new Laptop();
            l2.setL_id(102);
            l2.setRam(8);
            l2.setBrand("Lenovo");

            Laptop l3 = new Laptop();
            l3.setL_id(103);
            l3.setRam(32);
            l3.setBrand("Samsung");

            // Persist entities
            session.persist(l1);
            session.persist(l2);
            session.persist(l3);

            // Commit transaction
            transaction.commit();

            System.out.println("Laptops saved successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {

            // Resource management
            session.close();
            sessionFactory.close();
        }
    }
}