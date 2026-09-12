package springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("springcore") // scanning COMPONENTS i.e BEAN definitions
class AppConfig {
//
//    @Bean
//    public springcore.Laptop laptop() {
//        return new springcore.Laptop();
//    }
//
//    @Bean
//    public springcore.Computer computer(springcore.Laptop laptop) {
//        return new springcore.Computer(laptop);
//    }
//
//    @Bean
//    public springcore.Desktop desktop(springcore.Laptop laptop) {
//        springcore.Desktop desktop = new springcore.Desktop();
//        desktop.setLaptop(laptop);
//        return desktop;
//    }
//
//    @Bean
//    public springcore.Monitor monitor() {
//        return new springcore.Monitor();
//    }
}