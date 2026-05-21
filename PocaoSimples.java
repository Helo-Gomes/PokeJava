package PokeJava;

public class PocaoSimples implements Item{

    @Override
    public String getNome() {
        return "Poção simples";
    }

    @Override
    public void usar(Pokemon pokemon) {
        int recupera = pokemon.getHpMax()*30/100;
        int novoHp = pokemon.getHp() + recupera;

        //pega o menor valor entre o hp novo e o hp maximo
        //se novoHp for maior que o hpMaximo ele deixa o hpMaximo
        pokemon.setHp(Math.min(novoHp, pokemon.getHpMax()));
    }
}
