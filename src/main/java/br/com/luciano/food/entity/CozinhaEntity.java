package br.com.luciano.food.entity;

import br.com.luciano.food.model.Cozinha;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "tbl_cozinha")
public class CozinhaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cozinha")
    private Long id;
    private String nome;

    public CozinhaEntity() {}

    public CozinhaEntity(Cozinha cozinha) {
        if(cozinha != null) {
            this.id = cozinha.getId();
            this.nome = Objects.nonNull(cozinha.getName()) ? cozinha.getName() : "vazio";
        }
    }

    public Cozinha toModel() {
        Cozinha cozinha = new Cozinha();
        cozinha.setId(id);
        cozinha.setName(nome);
        return cozinha;
    }
}
