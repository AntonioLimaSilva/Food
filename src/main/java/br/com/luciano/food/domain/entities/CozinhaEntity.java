package br.com.luciano.food.domain.entities;

import br.com.luciano.food.api.models.Cozinha;
import br.com.luciano.food.api.models.Servico;
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

    @Enumerated(EnumType.STRING)
    private Servico servico;

    public CozinhaEntity() {}

    public CozinhaEntity(Cozinha cozinha) {
        if(cozinha != null) {
            this.id = cozinha.getId();
            this.nome = Objects.nonNull(cozinha.getName()) ? cozinha.getName() : "vazio";
            this.servico = cozinha.getServico();
        }
    }

    public Cozinha toModel() {
        Cozinha cozinha = new Cozinha();
        cozinha.setId(id);
        cozinha.setName(nome);
        cozinha.setServico(servico);
        return cozinha;
    }
}
