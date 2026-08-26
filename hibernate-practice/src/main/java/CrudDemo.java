import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CrudDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        // CREATE
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            Laptop laptop = new Laptop();
            laptop.setL_id(104);
            laptop.setRam(16);
            laptop.setBrand("Dell");

            session.persist(laptop);

            transaction.commit();

            System.out.println("Laptop saved successfully.");
        }

        // READ - find()
        try (Session session = sessionFactory.openSession()) {

            Laptop laptop = session.find(Laptop.class, 104);

            if (laptop != null) {
                System.out.println("Found: " + laptop);
            }
        }

        // READ - getReference()
        try (Session session = sessionFactory.openSession()) {

            Laptop laptop =
                    session.getReference(Laptop.class, 104);

            System.out.println("Reference: " + laptop);
        }

        // UPDATE - Dirty Checking
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            Laptop laptop = session.find(Laptop.class, 104);

            if (laptop != null) {

                laptop.setRam(32);

                // No explicit update() call.
                // Hibernate detects the change automatically.

                System.out.println("Laptop modified: " + laptop);
            }

            transaction.commit();

            System.out.println("Update committed using dirty checking.");
        }

        // DELETE - remove()
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            Laptop laptop = session.find(Laptop.class, 104);

            if (laptop != null) {
                session.remove(laptop);
            }

            transaction.commit();

            System.out.println("Laptop deleted successfully.");
        }
    }
}