package quiz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class arquivo {
	private String fileName = null;
	private FileInputStream fileReader;
	private BufferedReader bufferedReader;
    
	public arquivo (String fileName) throws  IOException{
    	this.fileName = fileName;
    	try {
    	fileReader = new FileInputStream (fileName);
    	bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
    	}catch(IOException e){
    		System.out.println("Arquivo Nao encontrado ");
    	}
    }
    public String proximaLinha() throws IOException {
    	return bufferedReader.readLine();   
    }
    public int numeroDePerguntas() throws IOException {
    	BufferedReader auxiliar = this.bufferedReader;
    	String line;
    	int i = 0;
    	while((line = auxiliar.readLine())!= null) {
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
    	this.fileReader.getChannel().position(0);
    	bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
    	return i;
    	
    }
    
}//endClass
