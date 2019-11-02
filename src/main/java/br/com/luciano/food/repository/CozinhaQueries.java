package br.com.luciano.food.repository;

import br.com.luciano.food.entity.CozinhaEntity;

import java.util.List;

public interface CozinhaQueries {

    List<CozinhaEntity> find(String nome);

}
