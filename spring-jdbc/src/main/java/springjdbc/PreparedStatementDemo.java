package springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class PreparedStatementDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

        JdbcTemplate jdbcTemplate =
                context.getBean(JdbcTemplate.class);

        String sql =
                "SELECT l_id, brand, ram FROM laptop WHERE ram > ?";

        int minimumRam = 16;

        jdbcTemplate.query(
                sql,
                ps -> ps.setInt(1, minimumRam),
                rs -> {
                    System.out.println(
                            rs.getInt("l_id") + " | "
                                    + rs.getString("brand") + " | "
                                    + rs.getInt("ram") + " GB"
                    );
                }
        );
    }
}