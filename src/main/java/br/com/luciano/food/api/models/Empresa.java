package br.com.luciano.food.api.models;

public class Empresa {

    private String nome;
    private Endereco endereco;

    public Empresa() {}

    private Empresa(Empresa empresa) {
        this.nome = empresa.getNome();
        this.endereco = empresa.getEndereco();
    }

    public static Empresa valueOf(Empresa original) {
        return new Empresa(original);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
