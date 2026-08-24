import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement()) {

            // Add multiple operations to the batch
            st.addBatch(
                    "INSERT INTO laptop (l_id, ram, brand) " +
                            "VALUES (106, 16, 'Dell')"
            );

            st.addBatch(
                    "INSERT INTO laptop (l_id, ram, brand) " +
                            "VALUES (107, 32, 'Acer')"
            );

            st.addBatch(
                    "UPDATE laptop SET ram = 64 WHERE l_id = 106"
            );

            int[] results = st.executeBatch();

            System.out.println("Batch executed successfully.");

            for (int rows : results) {
                System.out.println("Rows affected: " + rows);
            }

            // Cleanup demonstration records
            st.executeUpdate(
                    "DELETE FROM laptop WHERE l_id IN (106, 107)"
            );

            System.out.println("Temporary batch records removed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}