package quiz;

public class jogador {
String nome,sobrenome;
int pontuacao=0;
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getnome() {
		return this.nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getSobrenome() {
		return this.sobrenome;
	}
	public int getPontuacao() {
		return this.pontuacao;
	}	
	public void acertou(int pontos) {
		this.pontuacao =getPontuacao()+pontos;
	}
	public void errou(int pontos) {
		this.pontuacao = getPontuacao()-pontos;
	}
}
