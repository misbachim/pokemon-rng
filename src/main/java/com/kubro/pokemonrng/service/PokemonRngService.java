package com.kubro.pokemonrng.service;

import java.util.Random;

import com.kubro.pokemonrng.model.Pokemon;

import org.springframework.stereotype.Service;

@Service
public class PokemonRngService {
  
  public int catchPokemon() {
    Random rand = new Random(); 
    int value = rand.nextInt(2);
    return value;
  }

  public String renamePokemon(Pokemon pokemon) {
    return pokemon.getName() + "-" + fibonacci(pokemon.getRenameCount());
  }

  public int releasePokemon() {
    Random rand = new Random(); 
    int value = rand.nextInt(100);
    return value;
  }

  private int fibonacci(int n)  {
    if (n < 2) return n;

    return fibonacci(n - 1) + fibonacci(n - 2);
  }

}
