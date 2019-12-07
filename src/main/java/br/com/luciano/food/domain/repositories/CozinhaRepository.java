package br.com.luciano.food.domain.repositories;

import br.com.luciano.food.domain.entities.CozinhaEntity;
import br.com.luciano.food.api.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<CozinhaEntity, Long>,
        CozinhaQueries, JpaSpecificationExecutor<CozinhaEntity> {

    Optional<CozinhaEntity> findFirstByNome(String nome);

    List<CozinhaEntity> find(String nome);

    List<CozinhaEntity> findByServico(Servico servico);

}
