package br.com.luciano.food.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_restaturante")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    @Embedded
    private EnderecoEntity endereco;
    @ManyToOne
    @JoinColumn(name = "id_cozinha")
    private CozinhaEntity cozinha;
    @ManyToMany
    @JoinTable(name = "tbl_restaurante_forma_pgto",
            joinColumns = @JoinColumn(name = "id_restaurante"),
            inverseJoinColumns = @JoinColumn(name = "id_forma_pgto"))
    private List<FormaPagamento> formaPagamentos;

}
