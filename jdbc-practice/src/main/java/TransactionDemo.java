import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");

        String updateRam =
                "UPDATE laptop SET ram = ? WHERE l_id = ?";

        String updateBrand =
                "UPDATE laptop SET brand = ? WHERE l_id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ramPs = con.prepareStatement(updateRam);
             PreparedStatement brandPs = con.prepareStatement(updateBrand)) {

            con.setAutoCommit(false);

            try {

                // Operation 1
                ramPs.setInt(1, 32);
                ramPs.setInt(2, 101);
                ramPs.executeUpdate();

                // Operation 2
                brandPs.setString(1, "Apple Updated");
                brandPs.setInt(2, 101);
                brandPs.executeUpdate();

                con.commit();

                System.out.println("Transaction committed successfully.");

            } catch (SQLException e) {

                con.rollback();

                System.out.println("Transaction rolled back.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}