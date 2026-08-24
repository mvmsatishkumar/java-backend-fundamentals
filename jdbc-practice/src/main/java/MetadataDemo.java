import java.sql.*;

public class MetadataDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");

        String query = "SELECT * FROM laptop";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            // DatabaseMetaData
            DatabaseMetaData dbMetaData = con.getMetaData();

            System.out.println("Database: "
                    + dbMetaData.getDatabaseProductName());

            System.out.println("Database Version: "
                    + dbMetaData.getDatabaseProductVersion());

            System.out.println("Driver: "
                    + dbMetaData.getDriverName());

            System.out.println("Driver Version: "
                    + dbMetaData.getDriverVersion());

            // ResultSetMetaData
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(query)) {

                ResultSetMetaData rsMetaData = rs.getMetaData();

                int columnCount = rsMetaData.getColumnCount();

                System.out.println("\nColumns: " + columnCount);

                for (int i = 1; i <= columnCount; i++) {

                    System.out.println(
                            "Column " + i +
                                    ": " + rsMetaData.getColumnName(i) +
                                    " | Type: " +
                                    rsMetaData.getColumnTypeName(i)
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}