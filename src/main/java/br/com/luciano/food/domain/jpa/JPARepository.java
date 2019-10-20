package br.com.luciano.food.domain.jpa;

import br.com.luciano.food.domain.entity.CozinhaEntity;

import java.util.List;

public interface JPARepository<T> {

    T findById(Long id);

    T add(CozinhaEntity cozinhaEntity);

    List<T> findAll();

    void remove(Long id);

}
