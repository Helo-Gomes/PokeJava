# PokeJava
# Simulador de Batalha Pokémon — Resumo do Projeto

## Visão Geral

O projeto consiste em um simulador de batalha Pokémon desenvolvido em Java, executado via terminal, aplicando todos os conceitos fundamentais de Programação Orientada a Objetos. O jogador escolhe um Pokémon inicial, enfrenta um rival sorteado aleatoriamente e disputa uma batalha por turnos até que um dos Pokémons desmaia.

## Estrutura e Conceitos Aplicados

**Interface e Herança**
O sistema é construído sobre uma interface `Atacavel`, que define o contrato de combate para qualquer Pokémon. A classe abstrata `Pokemon` implementa essa interface e centraliza toda a lógica comum: receber dano, verificar se está vivo, aplicar efeitos de status e calcular ataques. As subclasses `PokemonFogo`, `PokemonAgua` e `PokemonPlanta` herdam de `Pokemon` e especializam apenas o que é específico de cada tipo.

**Encapsulamento**
Todos os atributos dos Pokémons são privados, acessados e modificados exclusivamente através de getters e setters. O HP máximo, por exemplo, não possui setter, pois não deve ser alterado após a criação do Pokémon. A bolsa de itens é criada automaticamente dentro do `Treinador`, garantindo que nenhum treinador exista sem seus itens.

**Polimorfismo**
O método `getStatusEspecial()` é abstrato em `Pokemon` e implementado de forma diferente em cada subclasse: `PokemonFogo` causa queimadura, `PokemonAgua` causa confusão e `PokemonPlanta` causa paralisia. O método `usarAtaqueEspecial()`, definido na classe base, utiliza polimorfismo para aplicar o status correto sem precisar saber qual tipo de Pokémon está atacando.

**Enumerações**
Dois enums estruturam o sistema: `TipoPokemon`, que define os três tipos disponíveis, e `StatusPokemon`, que representa os possíveis estados de um Pokémon durante a batalha — normal, queimado, confuso ou paralisado.

**Exceções Personalizadas**
Duas exceções foram criadas para situações específicas do jogo: `PokemonParalisadoException`, lançada quando um Pokémon tenta agir estando paralisado, fazendo-o perder o turno; e `HPInsuficienteException`, lançada quando o HP do Pokémon é insuficiente para pagar o custo do ataque especial.

**Sistema de Itens**
A interface `Item` define o comportamento de todos os itens da bolsa. Quatro classes concretas a implementam: `PocaoSimples`, que restaura 30% do HP máximo, e três antídotos que curam cada tipo de status. A classe `Bolsa` gerencia a lista de itens, removendo cada um após o uso — garantindo que cada item seja utilizado apenas uma vez por batalha.

**Batalha**
A classe `Batalha` orquestra todo o jogo. Ela gerencia o fluxo de turnos, o menu de ações do jogador, a inteligência artificial do rival e o cálculo de vantagem de tipo — onde Fogo vence Planta, Planta vence Água e Água vence Fogo, aplicando um multiplicador de 1.5x no dano. O rival age de forma aleatória, podendo atacar, usar ataque especial ou se defender a cada turno.

<img width="641" height="952" alt="image" src="https://github.com/user-attachments/assets/e9a1e13d-b56a-4563-833c-769a44c0cb67" />

---

## Fluxo do Jogo

O jogador informa seu nome e escolhe entre Squirtle, Bulbasaur ou Charmander. Em seguida, nomeia seu rival, que recebe um Pokémon sorteado aleatoriamente entre Squirtle, Charmander e Bulbasaur. A batalha ocorre em turnos: a cada rodada os efeitos de status são aplicados, o jogador escolhe sua ação e o rival responde automaticamente. A batalha termina quando o HP de um dos Pokémons chega a zero, exibindo a mensagem de vitória ou derrota.
