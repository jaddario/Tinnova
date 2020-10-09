package br.com.addario.main;

public class BubbleSort {

	private boolean ordenado = true;

	public int[] ordenar(int[] vetorASerOrdenado) {
		for (int i = 0; i < vetorASerOrdenado.length - 1; i++) {
			ordenado = true;
			for (int j = 0; j < vetorASerOrdenado.length - 1 - i; j++) {
				if (vetorASerOrdenado[j] > vetorASerOrdenado[j + 1]) {
					int auxiliar = vetorASerOrdenado[j];
					vetorASerOrdenado[j] = vetorASerOrdenado[j + 1];
					vetorASerOrdenado[j + 1] = auxiliar;
					ordenado = false;
				}
			}
			if (ordenado)
				break;
		}

		return vetorASerOrdenado;
	}
}
