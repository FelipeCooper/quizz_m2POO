package quiz;

import java.io.IOException;
import java.util.Scanner;

public class quiz {
	public static void main(String [] args) throws IOException {
		Scanner wr = new Scanner(System.in);
		
		jogador player1 = new jogador();
        arquivo arq1;
        System.out.println("Digite o nome do arquivo: ");
        arq1 = new arquivo(wr.next());
        questinario jogo1 = new questinario(arq1);
        System.out.println(arq1.numeroDePerguntas());
        jogo1.respostas(player1);
    }

}