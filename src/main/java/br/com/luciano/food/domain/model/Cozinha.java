package br.com.luciano.food.domain.model;

public class Cozinha {

    private Long id;
    private String nome;

    public Cozinha(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
