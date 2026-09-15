package springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CrudDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

        JdbcTemplate jdbcTemplate =
                context.getBean(JdbcTemplate.class);

        // INSERT
        String insertSql =
                "INSERT INTO laptop (l_id, brand, ram) VALUES (?, ?, ?)";

        int inserted = jdbcTemplate.update(
                insertSql, 301, "Dell", 16
        );

        System.out.println("Rows inserted: " + inserted);

        // UPDATE
        String updateSql =
                "UPDATE laptop SET ram = ? WHERE l_id = ?";

        int updated = jdbcTemplate.update(
                updateSql, 32, 301
        );

        System.out.println("Rows updated: " + updated);

        // DELETE
        String deleteSql =
                "DELETE FROM laptop WHERE l_id = ?";

        int deleted = jdbcTemplate.update(
                deleteSql, 301
        );

        System.out.println("Rows deleted: " + deleted);
    }
}