package br.com.luciano.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FoodApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FoodApplication.class, args);

    }

}
