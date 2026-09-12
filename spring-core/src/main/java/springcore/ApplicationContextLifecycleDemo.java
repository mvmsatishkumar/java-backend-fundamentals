package springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextLifecycleDemo {

     static void main() {

        System.out.println("1. Creating ApplicationContext...");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("2. ApplicationContext started.");

        System.out.println("3. Getting bean...");
        LifecycleBean bean = context.getBean(LifecycleBean.class);

        bean.execute();

        System.out.println("4. Closing ApplicationContext...");
        context.close();

        System.out.println("5. ApplicationContext closed.");
    }
}