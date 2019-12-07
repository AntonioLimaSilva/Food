package br.com.luciano.food.config;

import br.com.luciano.food.domain.integrations.Integrador;
import br.com.luciano.food.domain.integrations.IntegradorCozinhaBrasileira;
import br.com.luciano.food.domain.integrations.IntegradorCozinhaGourmet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegradorConfig {

    @Bean(name = "GOURMET")
    public Integrador integradorCozinhaItaliana() {
        return new IntegradorCozinhaGourmet();
    }

    @Bean(name = "BRASILEIRA")
    public Integrador integradorCozinhaBrasileira() {
        return new IntegradorCozinhaBrasileira();
    }
}
