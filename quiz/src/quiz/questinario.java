package quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class questinario {
	arquivo arq1;
	ArrayList<VerdadeiroFalso> list = new ArrayList<VerdadeiroFalso>();
	ArrayList<MultiplaEscolha> list2 = new ArrayList<MultiplaEscolha>();
	ArrayList<RespostaCurta> list3 = new ArrayList<RespostaCurta>();
	public questinario(arquivo arq1) {
		this.arq1=arq1;
	}
	public void respostas(jogador player1,int numePerguntas) throws IOException{	
			String line,resposta,gabarito;
			int pontos,i ,j,k;
			Scanner wr = new Scanner(System.in);
			while ((line=arq1.proximaLinha())!= null) { // cria os Objetos das perguntas
				if (line.compareTo("VF")== 0 ? true : false) {
					list.add (new VerdadeiroFalso(line,arq1));
				}
				if (line.compareTo("ME")== 0 ? true : false) {
					list2.add (new MultiplaEscolha(line,arq1));
				}
				if (line.compareTo("RC")== 0 ? true : false) {
					list3.add (new RespostaCurta(line,arq1));
				}
				
			}
			Collections.shuffle(list); //Embaralha as perguntas
			Collections.shuffle(list2);
			Collections.shuffle(list3);
			
			
				for(i=0 ;i<numePerguntas;i++) { //Apresenta as perguntas e ler a resposta
					if(list.size()>i) {
						gabarito = arq1.imprimir(0,list.get(i).getLinha());
						if (wr.next().compareToIgnoreCase(gabarito) == 0 ? true : false) {
							player1.acertou(list.get(i).getPontos());
							System.out.println("Acertou pontos="+player1.getPontuacao());
						}else {
							player1.errou(list.get(i).getPontos());
							System.out.println("Errou e perdeu pontos="+player1.getPontuacao());
						}
					}
					if(list2.size()>i) {
						gabarito = arq1.imprimir(list2.get(i).getAlternativas(),list2.get(i).getLinha());
						if (wr.next().compareToIgnoreCase(gabarito) == 0 ? true : false) {
							player1.acertou(list2.get(i).getPontos());
							System.out.println("Acertou pontos="+player1.getPontuacao());
						}else {
							player1.errou(list2.get(i).getPontos());
							System.out.println("Errou e perdeu pontos="+player1.getPontuacao());
						}
					}
					if(list3.size()>i) {
						gabarito = arq1.imprimir(0,list3.get(i).getLinha());
						if (wr.next().compareToIgnoreCase(gabarito) == 0 ? true : false) {
							player1.acertou(list3.get(i).getPontos());
							System.out.println("Acertou pontos="+player1.getPontuacao());
						}else {
							player1.errou(list3.get(i).getPontos());
							System.out.println("Errou e perdeu pontos="+player1.getPontuacao());
						}
					}
				}
		    }		
}