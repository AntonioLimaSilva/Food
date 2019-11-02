package br.com.luciano.food.repository;

import br.com.luciano.food.entity.CozinhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<CozinhaEntity, Long>, CozinhaQueries {

    Optional<CozinhaEntity> findFirstByNome(String nome);

    List<CozinhaEntity> find(String nome);

}
