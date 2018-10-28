package quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class questinario {
	arquivo arq1;
	public questinario(arquivo arq1) {
		this.arq1=arq1;
	}
	public void respostas(jogador player1) throws IOException{	
			String line,resposta;
			int pontos;
			Scanner wr = new Scanner(System.in);
	        while((line=arq1.proximaLinha()) != null) {
	        	//Creating questions model VF
	        	if (line.compareTo("VF") == 0 ? true : false) {
	        		pontos = valorQuestao(arq1.proximaLinha());
	        		line = imprimir(arq1,0);       		
	        		resposta = wr.next();
	        		if (resposta.compareToIgnoreCase(line) == 0 ? true : false) {
	        			player1.acertou(pontos);
	        			System.out.println("Acertou pontos="+player1.getPontuacao());
	        		}else {
	        			player1.errou(pontos);
	        			System.out.println("Errou e perdeu pontos="+player1.getPontuacao());
	        		}
	        	}
	        	if (line.compareTo("ME")== 0 ? true : false) {
	        		line = arq1.proximaLinha();
	        		int i = Integer.parseInt(line); // Loop counter for alternatives
	        		pontos = valorQuestao(arq1.proximaLinha());
	        		line = imprimir(arq1,i);
	        		resposta = wr.next();
	        		if (resposta.compareToIgnoreCase(line) == 0 ? true : false) {
	        			player1.acertou(pontos);
	        			System.out.println("Acertou pontos="+player1.getPontuacao());
	        		}else {
	        			player1.errou(pontos);
	        			System.out.println("Errou e perdeu pontos="+player1.getPontuacao());
	        		}
	        	}
	        	if(line.compareTo("RC")== 0 ? true : false) {
	        		line = arq1.proximaLinha();
	        		pontos = valorQuestao(line);
	        		line = imprimir(arq1,0);
	        		resposta = wr.next();
	        		if (resposta.compareToIgnoreCase(line) == 0 ? true : false) {
	        			player1.acertou(pontos);
	        			System.out.println("Acertou pontos="+player1.getPontuacao());
	        		}else {
	        			player1.errou(pontos);
	        			System.out.println("Errou e perdeu pontos="+player1.getPontuacao());
	        		}
	        	}
	        	
	        }       
	    }
	public String imprimir(arquivo line, int alt) throws IOException {
		String text=line.proximaLinha();
		String alternativas[] = {"","A","B","C","D","F","G","H","I","J"};
		System.out.println("Questao: "+text);
		text=line.proximaLinha();
		for (int i=1;i<=alt;i++) {
			System.out.println(alternativas[i]+") "+text);
			text=line.proximaLinha();
		}
		return text;
	}
	public int valorQuestao(String ponto) {
		System.out.println("Pontos: "+ponto);
		return Integer.parseInt(ponto);
	}
	public int contQuestoes() {
		
		return 0;
		
	}
}
