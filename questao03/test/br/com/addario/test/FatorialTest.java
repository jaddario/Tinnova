package br.com.addario.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.addario.main.Fatorial;

class FatorialTest {

	private Fatorial fatorial;

	@BeforeEach
	void init() {
		fatorial = new Fatorial();
	}

	@Test
	public void fatorialDeZeroEhIgualAUm() {
		int actual = fatorial.fatorialDe(0);
		assertEquals(1, actual);
	}

	@Test
	public void fatorialDeUmEhIgualAUm() {
		int actual = fatorial.fatorialDe(1);
		assertEquals(1, actual);
	}

	@Test
	public void fatorialDeDoisEhIgualADois() {
		int actual = fatorial.fatorialDe(2);
		assertEquals(2, actual);
	}

	@Test
	public void fatorialDeTresEhIgualASeis() {
		int actual = fatorial.fatorialDe(3);
		assertEquals(6, actual);
	}

	@Test
	public void fatorialDeQuatroEhIgualAVinteEQuatro() {
		int actual = fatorial.fatorialDe(4);
		assertEquals(24, actual);
	}

	@Test
	public void fatorialDeCincoEhIgualACentoEVinte() {
		int actual = fatorial.fatorialDe(5);
		assertEquals(120, actual);
	}

}
