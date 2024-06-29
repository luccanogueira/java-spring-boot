package br.com.alura.estudos_spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFilme(@JsonAlias("Title") String titulo, 
						 @JsonAlias("totalSeasons") String temporadas,
						 @JsonAlias("Year") String anosDuracao, 
						 @JsonAlias("imdbRating")String nota) {}
