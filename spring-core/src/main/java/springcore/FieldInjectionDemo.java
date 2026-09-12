package springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Monitor {

    @Autowired
    private Laptop laptop;

    public void display() {
        laptop.compile();
        System.out.println("springcore.Monitor is displaying...");
    }
}

public class FieldInjectionDemo {

    static void main() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Monitor monitor = context.getBean(Monitor.class);

        monitor.display();
    }
}