package PokeJava;

public class PocaoQueimadura implements Item{
    @Override
    public String getNome() {
        return "Poção para queimadura";
    }

    @Override
    public void usar(Pokemon pokemon) {
        pokemon.setStatus(StatusPokemon.NORMAL);
    }
}
