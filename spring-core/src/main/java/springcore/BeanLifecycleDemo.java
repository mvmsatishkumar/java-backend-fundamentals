package springcore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
class LifecycleBean {

    public LifecycleBean() {
        System.out.println("1. Constructor called.");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("2. @PostConstruct called.");
    }

    public void execute() {
        System.out.println("3. Bean is ready and being used.");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("4. @PreDestroy called.");
    }
}

public class BeanLifecycleDemo {

    static void main() {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        LifecycleBean bean =
                context.getBean(LifecycleBean.class);

        bean.execute();

        System.out.println("Closing ApplicationContext...");

        context.close();
    }
}