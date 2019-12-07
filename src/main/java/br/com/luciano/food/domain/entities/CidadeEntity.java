package br.com.luciano.food.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_cidade")
public class CidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private EstadoEntity estado;
}
