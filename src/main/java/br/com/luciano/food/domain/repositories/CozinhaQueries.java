package br.com.luciano.food.domain.repositories;

import br.com.luciano.food.domain.entities.CozinhaEntity;

import java.util.List;

public interface CozinhaQueries {

    List<CozinhaEntity> find(String nome);

}
