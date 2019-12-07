package br.com.luciano.food.domain.services;

import br.com.luciano.food.api.models.Cozinha;

public interface CozinhaService {

    Cozinha save(Cozinha cozinha);

    Cozinha execute(Cozinha cozinha);

}
