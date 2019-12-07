package br.com.luciano.food.infrastructure.specifications;

import br.com.luciano.food.domain.entities.CozinhaEntity;
import org.springframework.data.jpa.domain.Specification;

public class ObjectSpecifications {

    public static Specification<CozinhaEntity> withName(String name) {
        return (root, criteria, builder) ->
            builder.like(root.get("nome"), name);
    }


}
