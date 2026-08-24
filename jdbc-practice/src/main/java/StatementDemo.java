import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement()) {

            // executeQuery() -> SELECT
            String selectQuery = "SELECT * FROM laptop";

            try (ResultSet rs = st.executeQuery(selectQuery)) {

                while (rs.next()) {
                    int id = rs.getInt("l_id");
                    int ram = rs.getInt("ram");
                    String brand = rs.getString("brand");

                    System.out.println(id + " " + ram + " " + brand);
                }
            }

            // executeUpdate() -> UPDATE
            String updateQuery =
                    "UPDATE laptop SET ram = 32 WHERE l_id = 102";

            int rowsAffected = st.executeUpdate(updateQuery);

            System.out.println("Rows updated: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}