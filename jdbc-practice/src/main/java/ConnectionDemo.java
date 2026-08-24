
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            System.out.println("Database connected successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}