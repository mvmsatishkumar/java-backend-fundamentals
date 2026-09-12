package springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackageClasses = StereotypeAnnotationsDemo.class)
class StereotypeConfig {
}

@Component
class NotificationComponent {
    public void execute() {
        System.out.println("General component logic.");
    }
}

@Service
class NotificationService {
    public void sendNotification() {
        System.out.println("Business/service logic.");
    }
}

@Repository
class NotificationRepository {
    public void save() {
        System.out.println("Data access logic.");
    }
}

@Controller
class NotificationController {
    public void handleRequest() {
        System.out.println("Web request handling logic.");
    }
}

public class StereotypeAnnotationsDemo {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(StereotypeConfig.class);

        context.getBean(NotificationComponent.class).execute();
        context.getBean(NotificationService.class).sendNotification();
        context.getBean(NotificationRepository.class).save();
        context.getBean(NotificationController.class).handleRequest();
    }
}