package br.com.addario.main;

public class Votacao {
	private double totalEleitores;

	public Votacao(double totalEleitores) {
		this.totalEleitores = totalEleitores;
	}

	public double getPercentualVotosValidos(double numeroVotosValidos) {
		return numeroVotosValidos / totalEleitores;
	}

	public double getPercentualVotosBrancos(double numeroVotosBrancos) {
		return numeroVotosBrancos / totalEleitores;
	}

	public double getPercentualVotosNulos(double numeroVotosNulos) {
		return numeroVotosNulos / totalEleitores;
	}
}
