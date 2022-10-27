package main;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class memoriaVirtual {
	/*
	static RandomAccessFile memoriaVirtual;
	
	Scanner s = new Scanner(System.in);	
	String dados;
	String pos;

	public static void CriaArquivo(long tam, String nomeArquivo) {		//CRIA ARQUIVO DE ACORDO COM NOME INSERIDO E		
		try {																//E IMPLEMENTADO FOR PARA PREENCHER COM 0's DE	    	   
			memoriaVirtual = new RandomAccessFile(nomeArquivo+".bin", "rw");//ACORDO COM TAMANHO INSERIDO			
			for(long i = 0; i < tam; i++) {
				memoriaVirtual.writeByte(48); 
			}			
			System.out.println("... Arquivo Criado com Sucesso ! ...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void EscreverB(long pos, byte valor) {     
		//long pagina = controlador.somentePagina(bin); 	
		//char[] dado = Long.toString(bin).toCharArray();	
		//int pos = Integer.parseInt(valor);						
		
		try {
			memoriaVirtual.seek(pos);							
			memoriaVirtual.writeByte(dado[i]);									
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void LerB(long bin) { //CONTROLADOR BUSCA PAGINA INSERIDA
		try {					 //CRIADO METODO PARA ENCONTRAR A PAGINA
			//long pos = 0;		 //E EM SEGUIDA ARQUIVO É LIDO DE ACORDO COM A POSIÇÃO ENCONTRADA + TAMANHO DA PAGINA
			//int tamanhodapagina = 5;
			long pagina = controlador.somentePagina(bin);			
			int local = encontrarpagina(pagina);
		
			
			if(local != 20) { // TAMANHO DIFERENTE DO TAMANHO TOTAL (CASO NÃO ACHAR)
				memoriaVirtual.seek(local);
				System.out.println(memoriaVirtual.readLine().substring(local, 1024));
			} else {
				System.out.println("... Posição não Encontrada ! ...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int encontrarpagina(long pagina) throws IOException {	//APONTANDO PAGINAS A CADA PULOS DO 'J' (VARIA DE ACORDO COM O TAMANHO)
		boolean achou = false;										//E LE OS 3 PRIMEIROS CARACTERES E COMPARA COM A PAG INSERIDA
		int j = 0;
		byte[] b1 = new byte[3];		
		
		do{ 		
			memoriaVirtual.seek(j);
			memoriaVirtual.read(b1);			
			String pag = new String(b1, 0, 3);
		
			if(Long.parseLong(pag) == pagina) {
				//return Integer.parseInt(Long.toString(pagina));
				achou = true;
				return j;
			}else if(j < 20){ //J TEM QUE SER MENOR QUE O TAMANHO DO ARQUIVO PARA NÃO ENTRAR EM LOOP (PROCURAR MELHORIA)
				j += 10;				
			}else {
				return j;
			}
			
		}while (achou != true);
		
		return j;
	}
	
*/
}
	