package springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import springjdbc.dao.Laptop;

public class BeanPropertyRowMapperDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

        JdbcTemplate jdbcTemplate =
                context.getBean(JdbcTemplate.class);

        String sql = "SELECT l_id, brand, ram FROM laptop";

        List<Laptop> laptops = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Laptop.class)
        );

        laptops.forEach(System.out::println);
    }
}

//BeanPropertyRowMapper performs the mapping based on JavaBean property names:
//l_id  → lId
//brand → brand
//ram   → ram