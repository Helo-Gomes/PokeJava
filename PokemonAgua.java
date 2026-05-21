package PokeJava;

public class PokemonAgua extends Pokemon{

    public PokemonAgua(String nome, Integer hp, Integer hpMax, Integer ataque, Integer defesa) {
        super(nome, hp, hpMax, ataque, defesa, TipoPokemon.AGUA);
    }

    @Override
    public StatusPokemon getStatusEspecial() {
        return StatusPokemon.CONFUSO;
    }

    @Override
    public void ArtePokemon() {
        System.out.println("______________________________________________________________________\n" +
                        "[]     |      /|          \" __   \\  ' \\ ' ,-'   ,\".   `-. ' / ' /  /[]\n" +
                        "[]  \\ '      , |           / |.   .  \\ ' /   , ' \\ `     \\ ' / '  / []\n" +
                        "[] '         |,'          !_.'|   | '   ;   ,`\",  L,|     :   '  / /[]\n" +
                        "[]      |  ,'             '   |   |     |   .   ,    \\    |     / / []\n" +
                        "[]   \\ '  /              |`--'|   |     |    `-/ |   .    |    / / /[]\n" +
                        "[]  '    |    ,   .       `---'   |     :    |   |  ',,   ;   / / / []\n" +
                        "======================================================================\n");
    }


}
