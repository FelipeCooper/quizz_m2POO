package quiz;
teste
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class arquivo {
	private String fileName = null;
	private FileInputStream fileReader;
	private BufferedReader bufferedReader;
	private int numeroLinhas,vf=0,rc=0,me=0;
    
	public arquivo (String fileName) throws  IOException{ //Inicia a leitura do arquivo na primeira linha
    	this.fileName = fileName;
    	try {
    	fileReader = new FileInputStream (fileName);
    	bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
    	}catch(IOException e){
    		System.out.println("Arquivo Nao encontrado ");
    	}
    	numeroLinhas = numeroLinhas();
    }
    public String proximaLinha() throws IOException { 
    	return bufferedReader.readLine();   //Retorna a proxima linha
    }
    public int numeroDePerguntas() throws IOException {
    	BufferedReader auxiliar = this.bufferedReader;
    	String line;
    	int i = 0;
    	while((line = auxiliar.readLine())!= null) {   //vai de linha em linha a procura de perguntas
    		if (line.compareTo("VF")== 0 ? true : false) {
    			i++;
    		}
    		if (line.compareTo("ME")== 0 ? true : false) {
    			i++;
    		}
    		if (line.compareTo("RC")== 0 ? true : false) {
    			i++;
    		}
    	}
    	this.fileReader.getChannel().position(0); //volta a primeira linha do arquivo
    	bufferedReader = new BufferedReader(new InputStreamReader(fileReader)); 
    	return i;
    }
    public int getRc() {
    	return this.rc;
    }
    public int getMe() {
    	return this.me;
    }
    public int getVf() {
    	return this.vf;
    }
    public int numeroLinhas() throws IOException {
    	int i= 0;
    	String linha;
    	while((linha = bufferedReader.readLine())!=null) {
    		if (linha.compareTo("VF") == 0 ? true : false) {
    			this.vf++;
    		}
    		if (linha.compareTo("RC") == 0 ? true : false) {
    			this.rc++;
    		}
    		if (linha.compareTo("ME") == 0 ? true : false) {
    			this.me++;
    		}
    		i++;
    	}
    	this.fileReader.getChannel().position(0); //volta a primeira linha do arquivo
    	bufferedReader = new BufferedReader(new InputStreamReader(fileReader)); 
    	return i;
    }
    public int getLinha() throws IOException {
    	String aux,linha;
    	int i = 0;
    	aux = bufferedReader.readLine();
    	this.fileReader.getChannel().position(0); //volta a primeira linha do arquivo
    	bufferedReader = new BufferedReader(new InputStreamReader(fileReader));   	 
    	while ((linha = bufferedReader.readLine())!=null) {
    		if (aux.compareTo(linha) == 0 ? true : false) {
    			return (i);
    		}
    		i++;
    	}
		return 0;
    }
	public String imprimir(int alt,int linha) throws IOException {
		this.fileReader.getChannel().position(0); //volta a primeira linha do arquivo
    	bufferedReader = new BufferedReader(new InputStreamReader(fileReader)); 
    	for (int i = 1; i <= linha ; i++) {
    		proximaLinha();
    	}
		String text=proximaLinha();
		String alternativas[] = {"","A","B","C","D","F","G","H","I","J"};
		System.out.println("Questao: "+text);
		text=proximaLinha();
		for (int i=1;i<=alt;i++) {
			System.out.println(alternativas[i]+") "+text);
			text=proximaLinha();
		}
		return text; //retorna a resposta
	}
	
    
}//endClass
