package br.com.addario.main;

public class Fatorial {
	
	public int fatorialDe(int numero) {
		int antecessor = 1;
		int fatorial = 1;
		while (antecessor <= numero) {
			fatorial *= antecessor;
			antecessor++;
		}
		return fatorial;
	}
}
