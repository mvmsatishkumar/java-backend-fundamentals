package springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCDemo {

    static void main() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        Laptop laptop = context.getBean(BusinessLaptop.class);

        laptop.compile();
    }
}