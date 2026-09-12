package springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Desktop {

    private Laptop laptop;

    @Autowired
    @Qualifier("gamingLaptop")
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void build() {
        laptop.compile();
        System.out.println("springcore.Desktop is building...");
    }
}

public class SetterInjectionDemo {

    static void main() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Desktop desktop = context.getBean(Desktop.class);
        desktop.build();
    }
}