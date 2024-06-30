package br.com.alura.estudos_spring.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.estudos_spring.model.DadosEpisodio;
import br.com.alura.estudos_spring.model.DadosSerie;
import br.com.alura.estudos_spring.model.DadosTemporada;
import br.com.alura.estudos_spring.service.ConsumoApi;
import br.com.alura.estudos_spring.service.ConverteDados;

public class Principal {

	private ConsumoApi consumo = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();

	private DadosSerie dadosSerie = new DadosSerie(null, null, null, null);

	private final String URL = "https://www.omdbapi.com/?t=";
	private final String API_KEY = "&apikey=6585022c";

	private String json;

	private Scanner leitor = new Scanner(System.in);

	public void exibeMenu() {

		System.out.println("Digite o nome da série que está buscando: ");

		var nomeSerie = leitor.nextLine();

		System.out.println("O que você quer buscar: \n" + "1- dados sobre a serie; \n" + "2- dados das temporadas; \n"
				+ "3- dados de um epidosodio; \n" + "4- sair");

		var acao = leitor.nextLine();

		json = consumo.obterDados(URL + nomeSerie.replace(" ", "+") + API_KEY);
		this.dadosSerie = conversor.obeterDados(json, DadosSerie.class);

		if (acao.equals("1")) {

			System.out.println(dadosSerie);

		} else if (acao.equals("2")) {

			List<DadosTemporada> temporadas = new ArrayList<>();

			for (int i = 1; i <= dadosSerie.temporadas(); i++) {
				json = consumo.obterDados(URL + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);

				DadosTemporada dadosTep = conversor.obeterDados(json, DadosTemporada.class);

				temporadas.add(dadosTep);

			}
			temporadas.forEach(System.out::println);

		} else if (acao.equals("3")) {
			System.out.println("Digite numero da temporada: ");

			var numeroTemp = leitor.nextLine();

			System.out.println("Digite o numero do episodio: ");

			var numeroEp = leitor.nextLine();

			json = consumo.obterDados(
					URL + nomeSerie.replace(" ", "+") + "&season=" + numeroTemp + "&episode=" + numeroEp + API_KEY);

			DadosEpisodio dadosEp = conversor.obeterDados(json, DadosEpisodio.class);

			System.out.println(dadosEp);
		}
	}
}
