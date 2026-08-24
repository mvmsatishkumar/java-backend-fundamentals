import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement()) {

            // CREATE - INSERT
            String insertQuery =
                    "INSERT INTO laptop (l_id, ram, brand) " +
                            "VALUES (104, 16, 'Dell')";

            int inserted = st.executeUpdate(insertQuery);
            System.out.println("Rows inserted: " + inserted);

            // READ - SELECT
            String selectQuery = "SELECT * FROM laptop";

            try (ResultSet rs = st.executeQuery(selectQuery)) {

                System.out.println("\nLaptop Records:");

                while (rs.next()) {
                    int id = rs.getInt("l_id");
                    int ram = rs.getInt("ram");
                    String brand = rs.getString("brand");

                    System.out.println(id + " " + ram + " " + brand);
                }
            }

            // UPDATE
            String updateQuery =
                    "UPDATE laptop SET ram = 32 WHERE l_id = 104";

            int updated = st.executeUpdate(updateQuery);
            System.out.println("\nRows updated: " + updated);

            // DELETE
            String deleteQuery =
                    "DELETE FROM laptop WHERE l_id = 104";

            int deleted = st.executeUpdate(deleteQuery);
            System.out.println("Rows deleted: " + deleted);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}