package br.com.luciano.food.domain.main;

import br.com.luciano.food.FoodApplication;
import br.com.luciano.food.domain.entity.CozinhaEntity;
import br.com.luciano.food.domain.jpa.CozinhaImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InsertCozinha {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaImpl cozinhaImpl =  applicationContext.getBean(CozinhaImpl.class);

        CozinhaEntity cozinhaEntity = new CozinhaEntity();
        cozinhaEntity.setNome("japoneza");

        cozinhaImpl.add(cozinhaEntity);


        System.out.println("Finish" + cozinhaEntity.toString());
    }

}
