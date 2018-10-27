package quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class questinario {
	public void questions() throws IOException{
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
	        	if (line.compareTo("VF") == 0 ? true : false) {
	        		line = bufferedReader.readLine();
					pontos=Integer.parseInt(line);
	        		line = bufferedReader.readLine();
	        		System.out.println(line);
	        		line = bufferedReader.readLine();
	        		resposta = wr.next();
	        		if (resposta.compareToIgnoreCase(line) == 0 ? true : false) {
	        			player1.setPontuacao(pontos);
	        			System.out.println("Acertou pontos="+player1.getPontuacao());
	        		}else {
	        			player1.setPontuacao(0-pontos);
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
}
