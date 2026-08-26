import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RelationshipDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            // Create student
            Student student = new Student();
            student.setName("Satish");
            student.setMarks(85);

            // Create laptops
            Laptop laptop1 = new Laptop();
            laptop1.setL_id(201);
            laptop1.setBrand("Apple");
            laptop1.setRam(16);

            Laptop laptop2 = new Laptop();
            laptop2.setL_id(202);
            laptop2.setBrand("Lenovo");
            laptop2.setRam(8);

            // Establish bidirectional relationship
            laptop1.setStudent(student);
            laptop2.setStudent(student);

            List<Laptop> laptops = new ArrayList<>();
            laptops.add(laptop1);
            laptops.add(laptop2);

            student.setLaps(laptops);

            // Cascade persists laptops through Student
            session.persist(student);

            transaction.commit();

            System.out.println("Student saved successfully.");
            System.out.println(
                    "Generated Student ID: " + student.getS_id()
            );

            System.out.println("\nAssociated Laptops:");

            for (Laptop laptop : student.getLaps()) {
                System.out.println(laptop);
            }

            System.out.println(
                    "\nRelationship data remains in the database."
            );
        }

        sessionFactory.close();
    }
}