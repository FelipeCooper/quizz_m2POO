package quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class questinario {
	public void respostas() throws IOException{
		// The name of the file to open.
        String fileName = "jogo.txt";
        jogador player1 = new jogador();
        Scanner wr = new Scanner(System.in);
        // This will reference one line at a time
        String line = null,resposta;
        int pontos;
		try {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);
	
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	
	        while((line = bufferedReader.readLine()) != null) {
	        	//Creating questions model VF
	        	if (line.compareTo("VF") == 0 ? true : false) {
	        		pontos = valorQuestao(bufferedReader.readLine());
	        		line = imprimir(bufferedReader,0);       		
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
	        		line = bufferedReader.readLine();
	        		int i = Integer.parseInt(line); // Loop counter for alternatives
	        		pontos = valorQuestao(bufferedReader.readLine());
	        		line = imprimir(bufferedReader,i);
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
	        		line = bufferedReader.readLine();
	        		pontos = valorQuestao(line);
	        		line = imprimir(bufferedReader,0);
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
	
	        // Always close files.
	        bufferedReader.close();         
	    }
	    catch(FileNotFoundException ex) {
	        System.out.println(
	            "Arquivo nao encontrado'" + 
	            fileName + "'");                
	    }
	}
	public String imprimir(BufferedReader line, int alt) throws IOException {
		String text=line.readLine();
		String alternativas[] = {"","A","B","C","D","F","G","H","I","J"};
		System.out.println("Questao: "+text);
		text=line.readLine();
		for (int i=1;i<=alt;i++) {
			System.out.println(alternativas[i]+") "+text);
			text=line.readLine();
		}
		return text;
	}
	public int valorQuestao(String ponto) {
		System.out.println("Pontos: "+ponto);
		return Integer.parseInt(ponto);
	}
}
