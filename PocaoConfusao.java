package PokeJava;

public class PocaoConfusao implements Item{

    @Override
    public String getNome() {
        return "Poção para confusão mental";
    }

    @Override
    public void usar(Pokemon pokemon) {
        pokemon.setStatus(StatusPokemon.NORMAL);
    }
}
