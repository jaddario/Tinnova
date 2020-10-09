package br.com.addario.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.addario.main.SomaDeMultiplos;

class SomaDeMultiplosTest {

	private SomaDeMultiplos somaDeMultiplos;

	@BeforeEach
	void init() {
		somaDeMultiplos = new SomaDeMultiplos();
	}

	@Test
	void recebeNumeroDoisRetornaRetornaZero() {
		assertEquals(0, somaDeMultiplos.getSomaDeMultipos(2));
	}

	@Test
	void recebeNumeroTresRetornaRetornaZero() {
		assertEquals(0, somaDeMultiplos.getSomaDeMultipos(3));
	}

	@Test
	void recebeNumeroCincoRetornaTres() {
		assertEquals(3, somaDeMultiplos.getSomaDeMultipos(5));
	}

	@Test
	void recebeNumeroSeisRetornaQuinze() {
		assertEquals(8, somaDeMultiplos.getSomaDeMultipos(6));
	}

	@Test
	void recebeNumero10RetornaVinteETres() {
		assertEquals(23, somaDeMultiplos.getSomaDeMultipos(10));
	}

	@Test
	void recebeNumero15RetornaVinteETres() {
		assertEquals(45, somaDeMultiplos.getSomaDeMultipos(15));
	}

}
