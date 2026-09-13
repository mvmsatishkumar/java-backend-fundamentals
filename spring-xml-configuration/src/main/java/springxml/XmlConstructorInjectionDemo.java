package springxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Computer {

    private Laptop laptop;

    public Computer(Laptop laptop) {
        this.laptop = laptop;
    }

    public void compile() {
        laptop.compile();
        System.out.println("Computer is running...");
    }
}

public class XmlConstructorInjectionDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("constructor-config.xml");

        Computer computer =
                context.getBean("computer", Computer.class);

        computer.compile();
    }
}