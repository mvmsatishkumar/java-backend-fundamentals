import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HqlDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            // 1. SELECT
            Query<Laptop> selectQuery =
                    session.createQuery(
                            "FROM Laptop l",
                            Laptop.class
                    );

            List<Laptop> laptops =
                    selectQuery.getResultList();

            System.out.println("All Laptops:");

            for (Laptop laptop : laptops) {
                System.out.println(laptop);
            }

            // 2. WHERE + named parameter
            Query<Laptop> whereQuery =
                    session.createQuery(
                            "FROM Laptop l WHERE l.ram >= :ram",
                            Laptop.class
                    );

            whereQuery.setParameter("ram", 16);

            List<Laptop> highRamLaptops =
                    whereQuery.getResultList();

            System.out.println("\nLaptops with RAM >= 16:");

            for (Laptop laptop : highRamLaptops) {
                System.out.println(laptop);
            }

            // 3. LIKE + named parameter
            Query<Laptop> likeQuery =
                    session.createQuery(
                            "FROM Laptop l WHERE l.brand LIKE :brand",
                            Laptop.class
                    );

            likeQuery.setParameter("brand", "%a%");

            List<Laptop> matchingLaptops =
                    likeQuery.getResultList();

            System.out.println("\nBrands containing 'a':");

            for (Laptop laptop : matchingLaptops) {
                System.out.println(laptop);
            }

            // 4. ORDER BY
            Query<Laptop> orderQuery =
                    session.createQuery(
                            "FROM Laptop l ORDER BY l.ram DESC",
                            Laptop.class
                    );

            List<Laptop> sortedLaptops =
                    orderQuery.getResultList();

            System.out.println("\nSorted by RAM:");

            for (Laptop laptop : sortedLaptops) {
                System.out.println(laptop);
            }

            // 5. COUNT + getSingleResult()
            Query<Long> countQuery =
                    session.createQuery(
                            "SELECT COUNT(l) FROM Laptop l",
                            Long.class
                    );

            Long laptopCount =
                    countQuery.getSingleResult();

            System.out.println(
                    "\nTotal laptops: " + laptopCount
            );

            // 6. AVG aggregate function
            Query<Double> averageRamQuery =
                    session.createQuery(
                            "SELECT AVG(l.ram) FROM Laptop l",
                            Double.class
                    );

            Double averageRam =
                    averageRamQuery.getSingleResult();

            System.out.println(
                    "Average RAM: " + averageRam
            );

            // 7. JOIN - Student and Laptop
            Query<Object[]> joinQuery =
                    session.createQuery(
                            "SELECT s.name, l.brand, l.ram " +
                                    "FROM Student s " +
                                    "JOIN s.laps l",
                            Object[].class
                    );

            List<Object[]> joinResults =
                    joinQuery.getResultList();

            System.out.println("\nStudent-Laptop JOIN:");

            for (Object[] row : joinResults) {

                String studentName = (String) row[0];
                String laptopBrand = (String) row[1];
                Integer ram = (Integer) row[2];

                System.out.println(
                        studentName + " -> " +
                                laptopBrand + " (" +
                                ram + " GB)"
                );
            }

        } finally {

            sessionFactory.close();
        }
    }
}