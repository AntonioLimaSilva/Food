package br.com.luciano.food.domain.integration;

public class IntegradorCozinhaVegetariana implements Integrador {

    @Override
    public String execute(String nome) {
        System.out.println("Processando integrador vegetariano: " + nome);
        return nome;
    }
}
