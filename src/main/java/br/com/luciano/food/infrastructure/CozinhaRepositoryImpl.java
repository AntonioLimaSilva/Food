package br.com.luciano.food.infrastructure;

import br.com.luciano.food.domain.entities.CozinhaEntity;
import br.com.luciano.food.domain.repositories.CozinhaQueries;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CozinhaRepositoryImpl implements CozinhaQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<CozinhaEntity> find(String nome) {
        CriteriaBuilder builder = this.manager.getCriteriaBuilder();
        CriteriaQuery<CozinhaEntity> criteria = builder.createQuery(CozinhaEntity.class);
        Root<CozinhaEntity> root = criteria.from(CozinhaEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if(StringUtils.hasText(nome)) {
            predicates.add(builder.like(root.get("nome"), nome));
        }

        criteria.where(predicates.toArray(new Predicate[0]));

        TypedQuery<CozinhaEntity> query = this.manager.createQuery(criteria);

        return query.getResultList();
    }

}
