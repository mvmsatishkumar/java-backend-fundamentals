package springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcTemplateDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

        JdbcTemplate jdbcTemplate =
                context.getBean(JdbcTemplate.class);

//        DataSource dataSource = new DriverManagerDataSource(
//                "jdbc:postgresql://localhost:5432/demo",
//                "postgres",
//                System.getenv("DB_PASSWORD")
//        );
//
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(*) FROM laptop";

        Integer count =
                jdbcTemplate.queryForObject(sql, Integer.class);

        System.out.println("Total laptops: " + count);
    }
}