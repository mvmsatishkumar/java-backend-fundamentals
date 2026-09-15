package springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class QueryDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

        JdbcTemplate jdbcTemplate =
                context.getBean(JdbcTemplate.class);

        String sql = "SELECT l_id, brand, ram FROM laptop";

        RowMapper<String> rowMapper = (rs, rowNum) ->
                rs.getInt("l_id") + " | "
                        + rs.getString("brand") + " | "
                        + rs.getInt("ram") + " GB";

        List<String> laptops =
                jdbcTemplate.query(sql, rowMapper);

        laptops.forEach(System.out::println);
    }
}