package br.com.luciano.food.domain.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Embeddable
public class EnderecoEntity {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cidade")
    private CidadeEntity cidade;

}
