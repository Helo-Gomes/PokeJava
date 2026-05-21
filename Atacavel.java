package PokeJava;

public interface Atacavel {
    void atacar(Pokemon alvo, float multiplicador);
    void usarAtaqueEspecial(Pokemon alvo) throws HPInsuficienteException;
}