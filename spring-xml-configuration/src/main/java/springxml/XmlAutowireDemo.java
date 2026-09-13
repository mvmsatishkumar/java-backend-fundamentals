package springxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class AutowireComputer {

    private Printer printer;

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        printer.print();
        System.out.println("Computer is running...");
    }
}

class Printer {

    public void print() {
        System.out.println("Printer is printing...");
    }
}

public class XmlAutowireDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("autowire-config.xml");

        AutowireComputer computer =
                context.getBean("computer", AutowireComputer.class);

        computer.run();
    }
}