package PokeJava;

import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private Treinador jogador;
    private Treinador rival;
    private Pokemon pokemonRival;

    Scanner scanner = new Scanner(System.in);
    private Artes arte = new Artes();
    private Musica musica = new Musica();

    public void iniciar() {

        //inserir metodo do ascii de tela de inicio

        arte.arteInicial();

        System.out.println("                      OLÁ, BEM VINDO!");
        System.out.println("ESSE MUNDO É HABITADOS POR CRIATURAS INCÍVEIS CHAMADAS POKÉMON.");
        System.out.println("                AGORA, ME CONTE SOBRE VOCÊ.");
        System.out.println("                     QUAL SEU NOME? : ");
        String nome = scanner.nextLine();

        // chama arte ASCII com os 3 pokebolas

        System.out.println("                         ESCOLHA SEU POKÉMON!");
        System.out.println("            |0 - SQUIRTLE| 1 - BULBASAUR| 2 - CHARMANDER|");
        int escolha;
        Pokemon pokemonJogador = null;

        while(pokemonJogador == null){
            try{
                escolha = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um número valido.");
                continue;
            }
            switch (escolha){
                case 0:
                    pokemonJogador = new PokemonAgua("SQUIRTLE", 44, 44, 48, 65);

                    break;
                case 1:
                    pokemonJogador  = new PokemonPlanta("BULBASAUR", 45, 45, 49, 65);

                    break;
                case 2:
                    pokemonJogador  = new PokemonFogo("CHARMANDER", 50, 50, 52, 43);

                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        jogador = new Treinador(nome, pokemonJogador);

        System.out.println("VOCÊ ESCOLHEU "+pokemonJogador.getNome());

        // chamar ascii do pokemon escolhido ex
        // jogador.getPokemonEscolhido(getAscii);

        // Sorteia o pokemon rival
        Rivais listaRivais = new Rivais();
        pokemonRival = listaRivais.sortearRival();


        System.out.println("VOCÊ TEM UM RIVAL DE INFÂNCIA, QUAL O NOME DELE?");
        String nomeRival = scanner.nextLine();

        rival = new Treinador(nomeRival,pokemonRival);
        System.out.println("____________________________________________________");
        System.out.println();
        System.out.println("\n" + nomeRival + " ESCOLHEU UM " + pokemonRival.getNome()
                + " E TE DESAFIA PARA UMA BATALHA!");
        System.out.println();

    loopTurno();

    }

    public void loopTurno() {
        System.out.println("____________________________________________________");
        System.out.println("               A GRANDE BATALHA COMEÇA!   ");
        while(jogador.getPokemonEscolhido().estaVivo() && rival.getPokemonEscolhido().estaVivo()){
            //mudar para ascii
            arte.arteTurno();
            mostrarStats();
            try{
                jogador.getPokemonEscolhido().aplicarEfeitoStatus();
                menuTurno();
            }catch (PokemonParalisadoException e){
                System.out.println("POKEMON DE "+ jogador.getNomeTreinador() +" "+ jogador.getPokemonEscolhido().getNome()+" ESTÁ PARALIZADO E NÃO PODE SE MOVER!");
            }
         try {
             rival.getPokemonEscolhido().aplicarEfeitoStatus();
             turnoRival();
         }catch (PokemonParalisadoException e){
             System.out.println("POKEMON DE "+ rival.getNomeTreinador() +" "+rival.getPokemonEscolhido().getNome()+" ESTÁ PARALIZADO E NÃO PODE SE MOVER!");
         }

        }
        if(jogador.getPokemonEscolhido().estaVivo()){
            ganhou();
        } else {
            perdeu();
        }

    }public float vantagem(Pokemon atacante, Pokemon alvo) {
        if (atacante.getTipo() == TipoPokemon.FOGO && alvo.getTipo() == TipoPokemon.PLANTA) return 1.5f;
        if (atacante.getTipo() == TipoPokemon.PLANTA && alvo.getTipo() == TipoPokemon.AGUA) return 1.5f;
        if (atacante.getTipo() == TipoPokemon.AGUA && alvo.getTipo() == TipoPokemon.FOGO) return 1.5f;
        return 1.0f; // neutro
    }

    public void menuTurno(){
        System.out.println("                           O QUE DESEJA FAZER?");
        System.out.println("______________________________________________________________________");
        System.out.println("                 | 0 - LUTAR | 1 - FUGIR | 2 - BOLSA |");
        System.out.println("______________________________________________________________________");
        int menu = scanner.nextInt();

        switch (menu){
            case 0:
                menuLutar();
                break;
            case 1:
                System.out.println("VOCÊ NÃO PODE ESCAPAR DE UMA BATALHA CONTRA OUTRO TREINADOR!!");
                break;
            case 2:
                menuBolsa();
                break;
            default:
        }
    }

    public void menuLutar(){
        System.out.println("         0 - ATAQUE NORMAL | 1 - ATAQUE EPECIAL | 2 - ATAQUE ESCUDO");
        //depois aqui eu quero adicionar os ataque de cada tipo fazendo um overryde em cada tipo
        int menu = scanner.nextInt();

        switch (menu){
            case 0:

                float mult = vantagem(jogador.getPokemonEscolhido(), pokemonRival);
                jogador.getPokemonEscolhido().atacar(pokemonRival, mult);
                System.out.println("VOCÊ ATACOU "+pokemonRival.getNome() + " COM ATAQUE NORMAL!");

                break;
            case 1:

                try{
                    jogador.getPokemonEscolhido().usarAtaqueEspecial(pokemonRival);
                    System.out.println("VOCÊ ATACOU "+pokemonRival.getNome() + " COM ATAQUE ESPECIAL!");

                }catch (HPInsuficienteException e){
                    System.out.println("VOCÊ NÃO POSSUI HP SUFICIENTE PARA FAZER ISSO!");
                }

                break;
            case 2:
                jogador.getPokemonEscolhido().setEstaDefendendo(true);
                break;
            default:
                System.out.println("INVÁLIDO.");
        }
    }

    public void menuBolsa(){

        jogador.getBolsa().listarItens();
        System.out.println("                           QUAL ITEM QUER USAR?");
        int indiceItem = scanner.nextInt();

        jogador.getBolsa().usarItem(indiceItem, jogador.getPokemonEscolhido());

    }
    public void turnoRival() {
        Random random = new Random();
        int acao = random.nextInt(3); // 0, 1 ou 2

        switch(acao) {
            case 0: // ataque normal
                float mult = vantagem(rival.getPokemonEscolhido(), jogador.getPokemonEscolhido());
                rival.getPokemonEscolhido().atacar(jogador.getPokemonEscolhido(),mult);
                System.out.println( rival.getNomeTreinador()+" MANDOU "+ rival.getPokemonEscolhido().getNome()+ "ATACAR!");
                break;
            case 1: // ataque especial
            try{
                rival.getPokemonEscolhido().usarAtaqueEspecial(jogador.getPokemonEscolhido());
                System.out.println(rival.getPokemonEscolhido().getNome()+ " USOU ATAQUE ESPECIAL!");
                System.out.println(jogador.getPokemonEscolhido().getNome()
                        + " FICOU " + jogador.getPokemonEscolhido().getStatus() + "!");

            }catch (HPInsuficienteException e){
                System.out.println("O RIVAL TENTOU USAR ATAQUE ESPECIAL MAS NÃO TINHA HP SUFICIENTE.");
            }
                break;
            case 2: // defender
                System.out.println(rival.getPokemonEscolhido().getNome()
                        + " USOU ESCUDO!");
                rival.getPokemonEscolhido().setEstaDefendendo(true);
                break;
        }
    }

    public void ganhou(){
        System.out.println("O POKÉMON "+ rival.getPokemonEscolhido().getNome()+ " DESMAIOU!");
        arte.arteGanhou();
        System.out.println(jogador.getPokemonEscolhido().getNome() + " ganhou a Batalha");

    }
    public void perdeu(){
        System.out.println("O seu pokemon "+jogador.getPokemonEscolhido().getNome()+" desmaiou!");
        arte.artePerdeu();
        System.out.println("Você perdeu!");

    }
    public void mostrarStats(){

        jogador.getPokemonEscolhido().ArtePokemon();
        System.out.println("                          SEU POKEMON: " + jogador.getPokemonEscolhido().getNome());
        System.out.println("......................................................................");
        System.out.println("                          HP: " + jogador.getPokemonEscolhido().getHp()
                + "/" + jogador.getPokemonEscolhido().getHpMax()
                + "| STATUS: " + jogador.getPokemonEscolhido().getStatus());
        System.out.println("______________________________________________________________________");

        rival.getPokemonEscolhido().ArtePokemon();

        System.out.println("                         POKEMON RIVAL: " + rival.getPokemonEscolhido().getNome());
        System.out.println("......................................................................");
        System.out.println("                         HP: " + rival.getPokemonEscolhido().getHp()
                + "/" + rival.getPokemonEscolhido().getHpMax()
                + "| STATUS: " + rival.getPokemonEscolhido().getStatus());
        System.out.println("______________________________________________________________________");
    }
}
