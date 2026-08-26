import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FetchTypeDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        int studentId;

        // Find an existing student dynamically
        try (Session session = sessionFactory.openSession()) {

            Query<Integer> idQuery =
                    session.createQuery(
                            "SELECT MIN(s.s_id) FROM Student s",
                            Integer.class
                    );

            studentId = idQuery.getSingleResult();

            System.out.println(
                    "Using Student ID: " + studentId
            );
        }

        // -----------------------------------------
        // LAZY LOADING
        // -----------------------------------------

        try (Session session = sessionFactory.openSession()) {

            System.out.println("\n----- LAZY LOADING -----");

            Student student =
                    session.find(Student.class, studentId);

            System.out.println(
                    "Student loaded: " + student.getName()
            );

            System.out.println(
                    "Accessing laptops..."
            );

            for (Laptop laptop : student.getLaps()) {
                System.out.println(laptop);
            }
        }

        // -----------------------------------------
        // JOIN FETCH
        // -----------------------------------------

        try (Session session = sessionFactory.openSession()) {

            System.out.println("\n----- JOIN FETCH -----");

            Student student =
                    session.createQuery(
                                    "SELECT s " +
                                            "FROM Student s " +
                                            "JOIN FETCH s.laps " +
                                            "WHERE s.s_id = :id",
                                    Student.class
                            )
                            .setParameter("id", studentId)
                            .getSingleResult();

            System.out.println(
                    "Student loaded: " + student.getName()
            );

            System.out.println(
                    "Laptops already fetched:"
            );

            for (Laptop laptop : student.getLaps()) {
                System.out.println(laptop);
            }
        }

        sessionFactory.close();
    }
}