package PokeJava;

import java.util.ArrayList;
import java.util.List;

public class Bolsa {
    private List<Item> itens;

    public Bolsa() {
        itens = new ArrayList<>();
        itens.add(new PocaoSimples());
        itens.add(new PocaoQueimadura());
        itens.add(new PocaoConfusao());
        itens.add(new PocaoParalisia());
    }

    public void usarItem(int indice, Pokemon pokemon){

        if(indice >= 0 && indice < itens.size() ){
            itens.get(indice).usar(pokemon);
            itens.remove(indice);
        }else{
            System.out.println("ITEM INVÁLIDO.");
        }

    }

    public void listarItens(){
    System.out.println("______________________________________________________________________");
    System.out.println("                           ITENS DISPONÍVEIS:");

        for (int i = 0; i < itens.size(); i++) {
            if(itens.isEmpty()){
                System.out.println("                  BOLSA VAZIA!");
            }
            System.out.println("ITEM "+ i + " - "+ itens.get(i).getNome());
        }
    }
}
