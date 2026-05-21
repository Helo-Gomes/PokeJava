package PokeJava;

public class Treinador {
    private String nomeTreinador;
    private Pokemon pokemonEscolhido;
    private Bolsa bolsa;

    public Treinador(String nomeTreinador, Pokemon pokemonEscolhido){
        this.nomeTreinador = nomeTreinador;
        this.pokemonEscolhido = pokemonEscolhido;
        this.bolsa = new Bolsa();
    }

    public String getNomeTreinador() {
        return nomeTreinador;
    }

    public void setNomeTreinador(String nomeTreinador) {
        this.nomeTreinador = nomeTreinador;
    }

    public Pokemon getPokemonEscolhido() {
        return pokemonEscolhido;
    }

    public void setPokemonEscolhido(Pokemon pokemonEscolhido) {
        this.pokemonEscolhido = pokemonEscolhido;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }


}
