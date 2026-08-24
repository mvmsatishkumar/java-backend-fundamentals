import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            // INSERT
            String insertQuery =
                    "INSERT INTO laptop (l_id, ram, brand) VALUES (?, ?, ?)";

            try (PreparedStatement ps = con.prepareStatement(insertQuery)) {

                ps.setInt(1, 105);
                ps.setInt(2, 16);
                ps.setString(3, "HP");

                int rows = ps.executeUpdate();

                System.out.println("Rows inserted: " + rows);
            }

            // SELECT
            String selectQuery =
                    "SELECT * FROM laptop WHERE l_id = ?";

            try (PreparedStatement ps = con.prepareStatement(selectQuery)) {

                ps.setInt(1, 105);

                try (ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("l_id") + " " +
                                        rs.getInt("ram") + " " +
                                        rs.getString("brand")
                        );
                    }
                }
            }

            // UPDATE
            String updateQuery =
                    "UPDATE laptop SET ram = ? WHERE l_id = ?";

            try (PreparedStatement ps = con.prepareStatement(updateQuery)) {

                ps.setInt(1, 32);
                ps.setInt(2, 105);

                int rows = ps.executeUpdate();

                System.out.println("Rows updated: " + rows);
            }

            // DELETE
            String deleteQuery =
                    "DELETE FROM laptop WHERE l_id = ?";

            try (PreparedStatement ps = con.prepareStatement(deleteQuery)) {

                ps.setInt(1, 105);

                int rows = ps.executeUpdate();

                System.out.println("Rows deleted: " + rows);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}