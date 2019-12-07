package br.com.luciano.food.domain.integrations;

public class IntegradorCozinhaGourmet implements Integrador {

    @Override
    public String run(Long id) {
        return "Fazendo integracao da cozinha Gourmet";
    }
}
