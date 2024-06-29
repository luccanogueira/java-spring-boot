package br.com.alura.estudos_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.estudos_spring.model.DadosFilme;
import br.com.alura.estudos_spring.service.ConsumoApi;
import br.com.alura.estudos_spring.service.ConverteDados;

@SpringBootApplication
public class EstudosSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EstudosSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=the+big+bang+theory&apikey=6585022c");
		
		System.out.println(json);
		
		ConverteDados conversor = new ConverteDados();
		
		DadosFilme dados = conversor.obeterDados(json, DadosFilme.class);
		
		System.out.println(dados);
	}
}
