import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ExceptionDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            try {

                Laptop laptop = new Laptop();
                laptop.setL_id(109);
                laptop.setBrand("Asus");
                laptop.setRam(16);

                session.persist(laptop);

                // Simulate application validation failure
                if (laptop.getRam() < 32) {
                    throw new IllegalArgumentException(
                            "RAM must be at least 32 GB."
                    );
                }

                transaction.commit();

                System.out.println(
                        "Operation completed successfully."
                );

            } catch (Exception e) {

                if (transaction.isActive()) {
                    transaction.rollback();

                    System.out.println(
                            "Transaction rolled back."
                    );
                }

                System.out.println(
                        "Operation failed: " + e.getMessage()
                );
            }

        } finally {

            System.out.println(
                    "Exception handling completed."
            );

            sessionFactory.close();
        }
    }
}