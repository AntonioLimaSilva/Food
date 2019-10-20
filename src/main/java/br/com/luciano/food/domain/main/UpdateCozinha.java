package br.com.luciano.food.domain.main;

import br.com.luciano.food.FoodApplication;
import br.com.luciano.food.domain.entity.CozinhaEntity;
import br.com.luciano.food.domain.jpa.impl.CozinhaImpl;
import br.com.luciano.food.domain.model.Cozinha;
import br.com.luciano.food.domain.model.ServiceCozinha;
import br.com.luciano.food.domain.service.CozinhaService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class UpdateCozinha {

    public static void main(String[] args) {

        ApplicationContext ctx = new SpringApplicationBuilder(FoodApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

//        CozinhaImpl cozinhaImpl = ctx.getBean(CozinhaImpl.class);
        CozinhaService service = ctx.getBean(CozinhaService.class);
//
//        CozinhaEntity cozinhaEntity = cozinhaImpl.findById(1L);
//        cozinhaEntity.setNome("Americana");
//
//        cozinhaImpl.add(cozinhaEntity);

        service.salvar(ServiceCozinha.GOURMET, new Cozinha(1L, "Bla"));

    }

}
