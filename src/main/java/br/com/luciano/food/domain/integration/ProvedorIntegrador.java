package br.com.luciano.food.domain.integration;

import br.com.luciano.food.domain.model.ServiceCozinha;

public interface ProvedorIntegrador {

    Integrador get(ServiceCozinha serviceCozinha);

}
