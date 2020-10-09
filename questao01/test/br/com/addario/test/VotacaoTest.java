package br.com.addario.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.addario.main.Votacao;

class VotacaoTest {

	private Votacao votacao;

	@BeforeEach
	void init() {
		votacao = new Votacao(1000);
	}

	@Test
	void testaPercentualDeVotosValidosPeloTotalDeEleitores() {
		double percentualVotosValidos = votacao.getPercentualVotosValidos(800);
		assertEquals(0.8, percentualVotosValidos);
	}

	@Test
	void testaPercentualDeVotosBrancosPeloTotalDeEleitores() {
		double percentualVotosBrancos = votacao.getPercentualVotosBrancos(150);
		assertEquals(0.15, percentualVotosBrancos);
	}

	@Test
	void testaPercentualDeVotosNulosPeloTotalDeEleitores() {
		double percentualVotosNulos = votacao.getPercentualVotosNulos(50);
		assertEquals(0.05, percentualVotosNulos);
	}

}
