import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersistenceContextDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        int laptopId = 106;

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            // CREATE
            Laptop laptop = new Laptop();
            laptop.setL_id(laptopId);
            laptop.setBrand("Dell");
            laptop.setRam(16);

            session.persist(laptop);

            System.out.println("Laptop persisted.");

            // FIRST-LEVEL CACHE
            Laptop firstLoad =
                    session.find(Laptop.class, laptopId);

            Laptop secondLoad =
                    session.find(Laptop.class, laptopId);

            System.out.println(
                    "\nFirst object:  " + firstLoad
            );

            System.out.println(
                    "Second object: " + secondLoad
            );

            System.out.println(
                    "Same object: " + (firstLoad == secondLoad)
            );

            // DIRTY CHECKING
            firstLoad.setRam(32);

            System.out.println(
                    "\nRAM changed to 32."
            );

            // FLUSH
            session.flush();

            System.out.println(
                    "Session flushed."
            );

            // REFRESH
            firstLoad.setRam(64);

            System.out.println(
                    "RAM changed in Java object to 64."
            );

            session.refresh(firstLoad);

            System.out.println(
                    "After refresh: " + firstLoad
            );

            // DETACH
            session.detach(firstLoad);

            System.out.println(
                    "\nLaptop detached from persistence context."
            );

            firstLoad.setRam(128);

            System.out.println(
                    "RAM changed to 128 after detach."
            );

            // CLEAR
            session.clear();

            System.out.println(
                    "Persistence context cleared."
            );

            transaction.commit();
        }

        // Verify database state
        try (Session session = sessionFactory.openSession()) {

            Laptop laptop =
                    session.find(Laptop.class, laptopId);

            System.out.println(
                    "\nDatabase value after transaction: "
                            + laptop
            );

            // Cleanup
            Transaction transaction =
                    session.beginTransaction();

            if (laptop != null) {
                session.remove(laptop);
            }

            transaction.commit();

            System.out.println(
                    "Demo record cleaned up."
            );
        }

        sessionFactory.close();
    }
}