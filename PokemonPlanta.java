package PokeJava;

public class PokemonPlanta extends Pokemon{
    public PokemonPlanta(String nome, Integer hp, Integer hpMax, Integer ataque, Integer defesa) {
        super(nome, hp, hpMax, ataque, defesa, TipoPokemon.PLANTA);
    }

    @Override
    public StatusPokemon getStatusEspecial() {
        return StatusPokemon.PARALISADO;
    }

    @Override
    public void ArtePokemon() {
        System.out.println
                ("______________________________________________________________________\n" +
                 "[]   '         /   /  ..   `.  `./ | ;`.'   ,\"\" ,.  `.   \\      |   []\n" +
                "[]    `.     ,'  ,'   | |\\  |      \"       |  ,'\\ |   \\   `    ,L   []\n" +
                "[]    /|`.  /   '     | `-| '                /`-' |    L   `._/  \\  []\n" +
                "[]   / | .`|   |  .   `._.'                 `.__,'   .  |    |  (`  []\n" +
                "[]  '-\"\"-'_|   `. `.__,.____     .   _,        ____ ,-  j    \".-'\"' []\n" +
                "[]         \\     `-.  \\/.   `\"-.._   _,.---'\"\"\\/  \"_,.'     /-'     []\n" +
                "======================================================================\n");
    }
}
