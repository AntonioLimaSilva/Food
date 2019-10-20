package br.com.luciano.food.config;

import br.com.luciano.food.domain.integration.Integrador;
import br.com.luciano.food.domain.integration.IntegradorCozinhaGourmet;
import br.com.luciano.food.domain.integration.IntegradorCozinhaVegetariana;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class IntegradorConfig {

    @Bean(name = "GOURMET")
    @Scope("singleton")
    public Integrador integradorCozinhaItaliana() {
        return new IntegradorCozinhaGourmet();
    }

    @Bean(name = "VEGETARIANA")
    public Integrador integradorCozinhaBrasileira() {
        return new IntegradorCozinhaVegetariana();
    }
}
