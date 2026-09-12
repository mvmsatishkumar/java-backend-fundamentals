package springcore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("gamingLaptop")
class GamingLaptop implements Laptop {
    @Override
    public void compile() {
        System.out.println("Gaming laptop compiling...");
    }
}

@Primary
@Component("businessLaptop")
class BusinessLaptop implements Laptop {
    @Override
    public void compile() {
        System.out.println("Business laptop compiling...");
    }
}