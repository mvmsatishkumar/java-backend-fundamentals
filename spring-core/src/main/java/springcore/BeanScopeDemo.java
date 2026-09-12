package springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class SingletonLaptop {

    public SingletonLaptop() {
        System.out.println("SingletonLaptop object created.");
    }
}

@Component
@Scope("prototype")
class PrototypeLaptop {

    public PrototypeLaptop() {
        System.out.println("PrototypeLaptop object created.");
    }
}

public class BeanScopeDemo {

    static void main() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // ==============================
        // SINGLETON SCOPE
        // ==============================

        System.out.println("\n----- SINGLETON SCOPE -----");

        SingletonLaptop laptop1 =
                context.getBean(SingletonLaptop.class);

        SingletonLaptop laptop2 =
                context.getBean(SingletonLaptop.class);

        System.out.println("Laptop 1: " + laptop1);
        System.out.println("Laptop 2: " + laptop2);

        System.out.println(
                "Same object: " + (laptop1 == laptop2)
        );


        // ==============================
        // PROTOTYPE SCOPE
        // ==============================

        System.out.println("\n----- PROTOTYPE SCOPE -----");

        PrototypeLaptop prototypeLaptop1 =
                context.getBean(PrototypeLaptop.class);

        PrototypeLaptop prototypeLaptop2 =
                context.getBean(PrototypeLaptop.class);

        System.out.println(
                "Laptop 1: " + prototypeLaptop1
        );

        System.out.println(
                "Laptop 2: " + prototypeLaptop2
        );

        System.out.println(
                "Same object: " +
                        (prototypeLaptop1 == prototypeLaptop2)
        );
    }
}