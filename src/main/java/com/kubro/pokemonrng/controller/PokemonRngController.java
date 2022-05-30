package com.kubro.pokemonrng.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kubro.pokemonrng.model.Pokemon;
import com.kubro.pokemonrng.service.PokemonRngService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/pokemon-rng")
@Api(tags = {"pokemon-rng"})
public class PokemonRngController {
  
  @Autowired
  private PokemonRngService pokemonService;

  @RequestMapping(value = "/catch",
          method = RequestMethod.GET,
          produces = {"application/json", "application/xml"})
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get RNG to catch a Pokemon.", notes = "Return probability is 50% when catching Pokemon.")
  public
  @ResponseBody
  Integer catchPokemon(HttpServletRequest request, HttpServletResponse response) {
      return this.pokemonService.catchPokemon();
  }

  @RequestMapping(value = "/rename",
          method = RequestMethod.PUT,
          produces = {"application/json", "application/xml"})
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Rename a Pokemon.", notes = "Return a combination of first name assigned combined with Fibonacci sequence.")
  public
  @ResponseBody
  String renamePokemon(@RequestBody Pokemon pokemon,
                                HttpServletRequest request, HttpServletResponse response) {
      return this.pokemonService.renamePokemon(pokemon);
  }

  @RequestMapping(value = "/release",
          method = RequestMethod.GET,
          produces = {"application/json", "application/xml"})
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get a random number from 0 to 99.", notes = "Return a random number from 0 to 99.")
  public
  @ResponseBody
  Integer releasePokemon(HttpServletRequest request, HttpServletResponse response) {
      return this.pokemonService.releasePokemon();
  }

}
