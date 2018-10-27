package quiz;

public class jogador {
String nome,sobrenome;
int pontuacao;
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
	public void setPontuacao(int pontos) {
		this.pontuacao = pontos;
	}
	public int getPontuacao() {
		return this.pontuacao;
	}	
}
