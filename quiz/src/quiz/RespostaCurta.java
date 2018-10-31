package quiz;

import java.io.IOException;

public class RespostaCurta {
	private int linha,pontos;	
	arquivo arq1;
	public RespostaCurta(String linha,arquivo arq1) throws IOException {
		this.pontos = Integer.parseInt(arq1.proximaLinha());
		this.arq1 = arq1;		
		this.linha = arq1.getLinha();
	}
	public int getPontos() {
		return this.pontos;
	}
	public int getLinha() {
		return this.linha;
	}

}
