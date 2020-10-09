package br.com.addario.main;

import java.util.ArrayList;
import java.util.List;

public class SomaDeMultiplos {

	public int getSomaDeMultipos(int numeroLimite) {
		int numero = 0;
		List<Integer> multiplos = new ArrayList<Integer>();

		while (numero < numeroLimite) {
			if (numero % 3 == 0 || numero % 5 == 0) {
				multiplos.add(numero);
			}
			numero++;
		}

		Integer soma = multiplos.stream().reduce(0, Integer::sum);
		return soma;

	}

}
