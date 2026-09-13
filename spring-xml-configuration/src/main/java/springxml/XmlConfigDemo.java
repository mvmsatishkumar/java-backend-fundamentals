package springxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Laptop {

    public void compile() {
        System.out.println("Laptop is compiling...");
    }
}

public class XmlConfigDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Laptop laptop = context.getBean("laptop", Laptop.class);

        laptop.compile();
    }
}