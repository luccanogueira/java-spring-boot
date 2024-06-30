package br.com.alura.estudos_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.estudos_spring.principal.Principal;
import br.com.alura.estudos_spring.service.ConverteDados;

@SpringBootApplication
public class EstudosSpringApplication implements CommandLineRunner {
	
	ConverteDados conversor = new ConverteDados();
	
	public static void main(String[] args) {
		SpringApplication.run(EstudosSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		
		principal.exibeMenu();
	
	}
}
