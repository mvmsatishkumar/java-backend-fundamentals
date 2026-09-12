package springcore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class Computer {

    private final Laptop laptop;

    public Computer(@Qualifier("gamingLaptop") Laptop laptop) {
        this.laptop = laptop;
    }

    public void build() {
        laptop.compile();
        System.out.println("springcore.Computer is building...");
    }
}

@Configuration
@ComponentScan(basePackageClasses = Computer.class)
public class DependencyInjectionDemo {

    static void main() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(Computer.class);

        Computer computer = context.getBean(Computer.class);

        computer.build();
    }
}