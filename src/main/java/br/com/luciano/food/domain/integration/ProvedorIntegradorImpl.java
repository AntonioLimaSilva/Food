package br.com.luciano.food.domain.integration;

import br.com.luciano.food.domain.model.ServiceCozinha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ProvedorIntegradorImpl implements ProvedorIntegrador {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Integrador get(ServiceCozinha serviceCozinha) {
        return this.applicationContext.getBean(serviceCozinha.name(), Integrador.class);
    }
}
