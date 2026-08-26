import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EntityLifecycleDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            // TRANSIENT
            Laptop laptop = new Laptop();
            laptop.setL_id(105);
            laptop.setRam(16);
            laptop.setBrand("HP");

            System.out.println("Laptop created.");
            System.out.println("State: TRANSIENT");

            // PERSISTENT
            session.persist(laptop);

            System.out.println("Laptop persisted.");
            System.out.println("State: PERSISTENT");

            // Dirty checking
            laptop.setRam(32);

            System.out.println(
                    "RAM changed while entity is persistent."
            );

            // Commit first -> Hibernate flushes INSERT/UPDATE
            transaction.commit();

            System.out.println(
                    "Transaction committed."
            );

            // DETACHED
            session.detach(laptop);

            System.out.println("Laptop detached.");
            System.out.println("State: DETACHED");

            // This change is NOT automatically tracked
            laptop.setRam(64);

            System.out.println(
                    "RAM changed after detach; change is not tracked."
            );
        }

        // Cleanup the demonstration record
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            Laptop laptop = session.find(Laptop.class, 105);

            if (laptop != null) {
                session.remove(laptop);
            }

            transaction.commit();
        }

        System.out.println("Demo record cleaned up.");
    }
}