package PokeJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rivais {
    private List<Pokemon> listaRivais;

    public Rivais() {
        this.listaRivais = new ArrayList<>();
        listaRivais.add(new PokemonAgua("SQUIRTLE", 44, 44, 48, 65));
        listaRivais.add(new PokemonFogo("CHARMANDER", 50, 50, 52, 43));
        listaRivais.add(new PokemonPlanta("BULBASAUR", 45, 45, 49, 65));
    }

    public Pokemon sortearRival(){
        Random random = new Random();
        int pokemonAleatorio = random.nextInt(listaRivais.size());

        return listaRivais.get(pokemonAleatorio);
        }

}
