package quiz;

import java.io.IOException;

public class MultiplaEscolha {
	private int linha,pontos,alternativas;	
	arquivo arq1;
	public MultiplaEscolha(String linha,arquivo arq1) throws IOException {
		this.pontos = Integer.parseInt(arq1.proximaLinha());
		this.arq1 = arq1;	
		this.alternativas = Integer.parseInt(arq1.proximaLinha());
		this.linha = arq1.getLinha();
	}
	public int getPontos() {
		return this.pontos;
	}
	public int getAlternativas() {
		return this.alternativas;
	}
	public int getLinha() {
		return this.linha;
	}
}
