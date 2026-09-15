package springjdbc.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springjdbc.JdbcConfig;

public class DaoDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);

        LaptopDao dao =
                new LaptopDao(context.getBean(
                        org.springframework.jdbc.core.JdbcTemplate.class
                ));

        System.out.println("----- FIND ALL -----");
        dao.findAll().forEach(System.out::println);

        System.out.println("\n----- FIND BY ID -----");
        System.out.println(dao.findById(101));
    }
}