package br.com.alura.estudos_spring.service;

public interface IConveteDados {

	 <T> T obeterDados(String json, Class<T> classe);
}
