package br.com.addario.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.addario.main.BubbleSort;

class BubbleSortTest {

	private BubbleSort bubbleSort;

	@BeforeEach
	void init() {
		bubbleSort = new BubbleSort();
	}

	@Test
	void testaOrdenarComUmNumero() {
		int[] vetor = { 1 };
		int[] vetorOrdenado = bubbleSort.ordenar(vetor);
		assertArrayEquals(vetor, vetorOrdenado);
	}

	@Test
	void testaOrdenarComDoisNumerosOrdenados() {
		int[] vetor = { 1, 2 };
		int[] vetorOrdenado = bubbleSort.ordenar(vetor);
		assertArrayEquals(vetor, vetorOrdenado);
	}

	@Test
	void testaOrdenarComTresNumerosOrdenados() {
		int[] vetor = { 1, 2, 3 };
		int[] vetorOrdenado = bubbleSort.ordenar(vetor);
		assertArrayEquals(vetor, vetorOrdenado);
	}

	@Test
	void testaOrdenarComDoisNumerosDesordenados() {
		int[] vetor = { 2, 1 };
		int[] vetorEsperado = { 1, 2 };
		int[] vetorOrdenado = bubbleSort.ordenar(vetor);
		assertArrayEquals(vetorEsperado, vetorOrdenado);
	}

	@Test
	void testaOrdenarComTresNumerosDesordenados() {
		int[] vetor = { 2, 3, 1 };
		int[] vetorEsperado = { 1, 2, 3 };
		int[] vetorOrdenado = bubbleSort.ordenar(vetor);
		assertArrayEquals(vetorEsperado, vetorOrdenado);
	}

	@Test
	void testaOrdenarComVariosNumerosDesordenados() {
		int[] vetor = { 5, 4, 9, 6, 3, 7, 2, 1, 8 };
		int[] vetorEsperado = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] vetorOrdenado = bubbleSort.ordenar(vetor);
		assertArrayEquals(vetorEsperado, vetorOrdenado);
	}

	@Test
	void testaOrdenarComNumerosDesordenadosEValoresRepetidos() {
		int[] vetor = { 5, 4, 9, 6, 6, 7, 2, 1, 3, 3 };
		int[] vetorEsperado = { 1, 2, 3, 3, 4, 5, 6, 6, 7, 9 };
		int[] vetorOrdenado = bubbleSort.ordenar(vetor);
		assertArrayEquals(vetorEsperado, vetorOrdenado);
	}

}
