import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TransactionDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        // -------------------------------
        // TRANSACTION 1 - COMMIT
        // -------------------------------

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            try {

                Laptop laptop1 = new Laptop();
                laptop1.setL_id(107);
                laptop1.setBrand("Dell");
                laptop1.setRam(16);

                Laptop laptop2 = new Laptop();
                laptop2.setL_id(108);
                laptop2.setBrand("HP");
                laptop2.setRam(32);

                session.persist(laptop1);
                session.persist(laptop2);

                transaction.commit();

                System.out.println(
                        "Transaction 1 committed successfully."
                );

            } catch (Exception e) {

                transaction.rollback();

                System.out.println(
                        "Transaction 1 rolled back."
                );

                e.printStackTrace();
            }
        }

        // -------------------------------
        // TRANSACTION 2 - ROLLBACK
        // -------------------------------

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            try {

                Laptop laptop = session.find(
                        Laptop.class,
                        107
                );

                if (laptop != null) {

                    laptop.setRam(64);

                    System.out.println(
                            "RAM changed to 64."
                    );
                }

                // Simulate an application failure
                throw new RuntimeException(
                        "Simulated transaction failure"
                );

            } catch (Exception e) {

                transaction.rollback();

                System.out.println(
                        "Transaction 2 rolled back."
                );

                System.out.println(
                        "Reason: " + e.getMessage()
                );
            }
        }

        // -------------------------------
        // VERIFY ROLLBACK
        // -------------------------------

        try (Session session = sessionFactory.openSession()) {

            Laptop laptop = session.find(
                    Laptop.class,
                    107
            );

            if (laptop != null) {

                System.out.println(
                        "\nAfter rollback:"
                );

                System.out.println(laptop);
            }
        }

        // -------------------------------
        // CLEANUP
        // -------------------------------

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction =
                    session.beginTransaction();

            Laptop laptop107 =
                    session.find(Laptop.class, 107);

            Laptop laptop108 =
                    session.find(Laptop.class, 108);

            if (laptop107 != null) {
                session.remove(laptop107);
            }

            if (laptop108 != null) {
                session.remove(laptop108);
            }

            transaction.commit();

            System.out.println(
                    "\nTransaction demo records cleaned up."
            );
        }

        sessionFactory.close();
    }
}