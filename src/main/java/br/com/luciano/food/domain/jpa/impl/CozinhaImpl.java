package br.com.luciano.food.domain.jpa.impl;

import br.com.luciano.food.domain.entity.CozinhaEntity;
import br.com.luciano.food.domain.jpa.JPARepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CozinhaImpl implements JPARepository<CozinhaEntity> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public CozinhaEntity findById(Long id) {
        return this.manager.find(CozinhaEntity.class, id);
    }

    @Transactional
    @Override
    public CozinhaEntity add(CozinhaEntity cozinhaEntity) {
        return this.manager.merge(cozinhaEntity);
    }

    @Override
    public List<CozinhaEntity> findAll() {
        return this.manager.createQuery("from CozinhaEntity").getResultList();
    }

    @Override
    public void remove(Long id) {
        CozinhaEntity cozinhaEntity = this.findById(id);

        if(cozinhaEntity != null) {
            this.manager.remove(cozinhaEntity);
        }
    }
}
