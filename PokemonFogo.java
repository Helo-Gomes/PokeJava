package PokeJava;

public class PokemonFogo extends Pokemon{


    public PokemonFogo(String nome, Integer hp, Integer hpMax, Integer ataque, Integer defesa) {
        super(nome, hp, hpMax, ataque, defesa, TipoPokemon.FOGO);
    }

    @Override
    public StatusPokemon getStatusEspecial() {
        return StatusPokemon.QUEIMADO;
    }

    @Override
    public void ArtePokemon() {
        System.out.println("______________________________________________________________________\n" +
                        "[]    |  |            _.    \\  ' \\ ' ,-' \\   ---._ `-.     `-. ' / '[]\n" +
                        "[] \\ '   ,|    ,   _.'  Y    \\  \\ ' /     `- ,'   \\   `.`.    \\ '  /[]\n" +
                        "[]'      l'    \\ ,'._,\\ `.    .  ' ;        /       ,--. l     :  / []\n" +
                        "[]    .,-        `._  |  |    |    |        \\       _   l .    | / /[]\n" +
                        "[]   /              `\"--'    /     |       .'       ``. |  )   |/ / []\n" +
                        "[]  .\\    ,                 |      :        .        \\ `. '    ; / /[]\n" +
                        "======================================================================\n");
    }


}


