package PokeJava;

import java.util.Random;

public abstract class Pokemon implements Atacavel{
    private String nome;
    private Integer hp;
    private Integer hpMax;
    private Integer ataque;
    private Integer defesa;
    private TipoPokemon tipo;
    private StatusPokemon status;
    private Boolean estaDefendendo;

    public Pokemon(String nome, Integer hp, Integer hpMax, Integer ataque,
                   Integer defesa, TipoPokemon tipo) {
        this.nome = nome;
        this.hp = hp;
        this.hpMax = hpMax;
        this.ataque = ataque;
        this.defesa = defesa;
        this.tipo = tipo;
        this.status = StatusPokemon.NORMAL;
        this.estaDefendendo = false;
    }

    //getters/setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getHpMax() {
        return hpMax;
    }

//    public void setHpMax(Integer hpMax) {
//        this.hpMax = hpMax;
//    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public StatusPokemon getStatus() {
        return status;
    }

    public void setStatus(StatusPokemon status) {
        this.status = status;
    }

    public Boolean getEstaDefendendo() {
        return estaDefendendo;
    }

    public void setEstaDefendendo(Boolean estaDefendendo) {
        this.estaDefendendo = estaDefendendo;
    }

    //Metodos

    public void receberDano(int dano){

        if(estaVivo()){
            if (estaDefendendo){
                dano -=  dano/2;
                estaDefendendo = false;
            }
            if(dano > hp){
                hp = 0;
            }else {
                hp = hp - dano;
            }
        }
    }

    public boolean estaVivo(){
     return hp > 0;
    }

    public void aplicarEfeitoStatus() throws PokemonParalisadoException{
        int dano;
        switch (getStatus()){
            case QUEIMADO:
                //perde 10% de hp maximo por turno
                dano = getHpMax() * 10 / 100;
                receberDano(dano);
                System.out.println("O POKEMON FOI FERIDO COM QUEIMADURA");
                break;
            case CONFUSO:
                //perde 5% de hp maximo por turno
                dano = getHpMax() * 5 / 100;
                receberDano(dano);
                System.out.println("O POKEON ESTÁ CONFUSO, E ATACOU A SI MESMO EM SUA CONFUSÃO.");
                break;
            case PARALISADO:
                throw new PokemonParalisadoException("O POKEMON ESTÁ PARALISADO E NÃO CONSEGUE SE MEXER!");

            case NORMAL:
                break;
            default:
        }
    }

    public abstract StatusPokemon getStatusEspecial();

    public abstract void ArtePokemon();


//implementa interface Atacavel
    @Override
    public void atacar(Pokemon alvo, float multiplicador ) {
        Random random = new Random();
        int efetividade = random.nextInt(40 - 20 + 1) + 20; // valor aleatório de efetividade ajustar se necessario
        int danoFinal = (int)(ataque * efetividade / 100 * multiplicador);
        alvo.receberDano(danoFinal);

    }

    @Override
    public void usarAtaqueEspecial(Pokemon alvo) throws HPInsuficienteException{

        if(estaVivo() && hp>15){
            receberDano(15); //tira 15 do seu próprio hp
            alvo.setStatus(getStatusEspecial());
        }else{
            throw new HPInsuficienteException("HP INSUFICIENTE !");
        }
        System.out.println(getNome()+ " USOU ATAQUE ESPECIAL!");
        System.out.println(alvo.getNome() + " FICOU " + alvo.getStatus());

    }
}
