package springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SingleRowQueryDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

        JdbcTemplate jdbcTemplate =
                context.getBean(JdbcTemplate.class);

        String sql =
                "SELECT brand FROM laptop WHERE l_id = ?";

        String brand = jdbcTemplate.queryForObject(
                sql,
                String.class,
                101
        );

        System.out.println("Brand: " + brand);
    }
}

//Remember
//query()
//    → multiple rows
//    → List<T>
//
//queryForObject()
//    → exactly one result
//    → single T