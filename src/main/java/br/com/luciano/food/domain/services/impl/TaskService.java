package br.com.luciano.food.domain.services.impl;

import br.com.luciano.food.domain.integrations.Integrador;
import br.com.luciano.food.api.models.Cozinha;
import br.com.luciano.food.api.models.Servico;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.Callable;

public class TaskService implements Callable<Cozinha> {

    private ApplicationContext ctx;
    private Servico servico;
    private Long id;

    public TaskService(ApplicationContext ctx, Servico servico, Long id) {
        this.ctx = ctx;
        this.servico = servico;
        this.id = id;
    }

    @Override
    public Cozinha call() throws Exception {
        Integrador integrador = ctx.getBean(servico.name(), Integrador.class);
        String nome = integrador.run(id);

        Cozinha cozinha = new Cozinha();
        cozinha.setName(nome);

        System.out.println(">>>>> Integrador: " + integrador);

        return cozinha;
    }
}
