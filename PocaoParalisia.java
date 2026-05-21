package PokeJava;

public class PocaoParalisia implements Item{
    @Override
    public String getNome() {
        return "Poção para paralisia.";
    }

    @Override
    public void usar(Pokemon pokemon) {
        pokemon.setStatus(StatusPokemon.NORMAL);
    }
}
