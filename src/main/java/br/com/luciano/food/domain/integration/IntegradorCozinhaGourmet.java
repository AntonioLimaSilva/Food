package br.com.luciano.food.domain.integration;

public class IntegradorCozinhaGourmet implements Integrador {

    @Override
    public String execute(String nome) {
        System.out.println("Processando integrador gourmet: " + nome);
        return nome;
    }
}
