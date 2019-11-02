package br.com.luciano.food.infrastructure;

import br.com.luciano.food.entity.CozinhaEntity;
import br.com.luciano.food.repository.CozinhaQueries;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CozinhaRepositoryImpl implements CozinhaQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<CozinhaEntity> find(String nome) {

        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        query.append("from CozinhaEntity where 0 = 0 ");

        if(!StringUtils.isEmpty(nome)) {
            query.append("and nome like :nome");
            params.put("nome", "%" + nome + "%");
        }

        TypedQuery<CozinhaEntity> typedQuery = this.manager.createQuery(query.toString(), CozinhaEntity.class);

        params.forEach((k, v) -> {
            typedQuery.setParameter(k, v);
        });

        return typedQuery.getResultList();
    }

}
