package springxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Desktop {

    private Laptop laptop;

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void compile() {
        laptop.compile();
        System.out.println("Desktop is running...");
    }
}

public class XmlSetterInjectionDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("setter-config.xml");

        Desktop desktop =
                context.getBean("desktop", Desktop.class);

        desktop.compile();
    }
}