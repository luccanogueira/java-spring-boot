package br.com.alura.estudos_spring.service;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConveteDados{

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T obeterDados(String json, Class<T> classe) {
		
		try {
			return mapper.readValue(json, classe);
		} catch (JsonProcessingException e) {
			throw new RuntimeErrorException(null);
		}
		
	}
	
	
}


