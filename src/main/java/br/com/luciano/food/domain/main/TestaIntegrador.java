package br.com.luciano.food.domain.main;

import br.com.luciano.food.FoodApplication;
import br.com.luciano.food.domain.entity.CozinhaEntity;
import br.com.luciano.food.domain.integration.Integrador;
import br.com.luciano.food.domain.integration.ProvedorIntegrador;
import br.com.luciano.food.domain.jpa.impl.CozinhaImpl;
import br.com.luciano.food.domain.model.ServiceCozinha;
import br.com.luciano.food.tasks.Message;
import br.com.luciano.food.tasks.MessageImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class TestaIntegrador {

    public static void main(String[] args) {

//        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);

//        ProvedorIntegrador provedorIntegrador = applicationContext.getBean(ProvedorIntegrador.class);
//
//        Integrador i = provedorIntegrador.get(ServiceCozinha.GOURMET);
//
//        i.execute("Bla");

//        Message message = applicationContext.getBean(MessageImpl.class);

        Bloco b = Bloco.get("F900");

        String xpto = "abcdefrgh";

        String x = xpto.substring(4);

        System.out.println("Finish: " + x);
    }

}

enum Bloco {

    F900, T999, NOTFOUND;

    public static Bloco get(String value) {
        try {
            return Bloco.valueOf(value);
        } catch (Exception ex) {
            return NOTFOUND;
        }
    }

}
