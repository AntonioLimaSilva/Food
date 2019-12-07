package br.com.luciano.food.domain.integrations;

public class IntegradorCozinhaBrasileira implements Integrador {

    @Override
    public String run(Long id) {
        return "Fazendo integracao da cozinha Brasileira";
    }
}
