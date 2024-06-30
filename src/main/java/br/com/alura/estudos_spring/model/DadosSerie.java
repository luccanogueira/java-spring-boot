package br.com.alura.estudos_spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo, 
						 @JsonAlias("totalSeasons") Integer temporadas,
						 @JsonAlias("Year") String anosDuracao, 
						 @JsonAlias("imdbRating")String nota) {}
