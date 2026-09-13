package springxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlImportDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("main-config.xml");

        Laptop laptop =
                context.getBean("importedLaptop", Laptop.class);

        laptop.compile();
    }
}