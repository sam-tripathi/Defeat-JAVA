package main;

import java.util.Scanner;

public class index {
	static int nPagVirtuais = -1;
	static String nomeArquivo;
	static int nPagReais = -1;
	static int tamPagina = -1;
	static Paginacao paginacao=null;
	
	public static void main(String[] args) {		
		
		Scanner s = new Scanner(System.in);
		String estado = "aguardo";
		
		String parametro1 = "";
		String parametro2 = "";		
		
		while (!estado.contentEquals("finalizar")){
			if (!estado.contentEquals("iniciar")){
				System.out.println("Favor digite 'iniciar' para começar");
			}
			
			String input = s.nextLine();
			
			String[] inputVetor = input.split(" ");
			
			String comando = inputVetor[0]; 
			
			if(inputVetor.length > 1)
				parametro1 = inputVetor[1]; 
			if(inputVetor.length == 3)
				parametro2 = inputVetor[2]; 
			
			estado = Comandos(comando, parametro1, parametro2, estado);
		}
		
	}
	
	public static String Comandos(String comando, String parametro1, String parametro2, String estado) {	
		
		switch (comando){
			case "iniciar":
				estado = comando;
				System.out.println("O sistema foi inicializado");
				break;
				
			case "finalizar":
				estado = comando;
				System.out.println("O sistema está se encerrando");
				break;
				
			case "fis":
				if (ProgramaIniciado(estado))
				{					
					if(nPagVirtuais != -1) {
						paginacao = new Paginacao(Integer.valueOf(parametro2), nPagVirtuais, Integer.valueOf(parametro1), nomeArquivo);
					}
					tamPagina = Integer.valueOf(parametro2);
					nPagReais = Integer.valueOf(parametro1);
				}
				break;
				
			case "vir":
				if (ProgramaIniciado(estado))
				{					
					if(nPagReais != -1) {
						paginacao = new Paginacao(tamPagina, Integer.valueOf(parametro1), nPagReais, parametro2);
					}
					nPagVirtuais = Integer.valueOf(parametro1);
					nomeArquivo = parametro2;
				}
				break;
							
			case "ler_b":
				if (ProgramaIniciado(estado))
				{
					paginacao.LerB(Integer.valueOf(parametro1));	// 1 byte	
					System.out.println();
				}
				break;
				
			case "ler_w":
				if (ProgramaIniciado(estado))
				{			
					paginacao.LerW(Integer.valueOf(parametro1));// 2 bytes	
					System.out.println("\n");
				}
				break;
				
			case "ler_l":
				if (ProgramaIniciado(estado))
				{
					paginacao.LerL(Integer.valueOf(parametro1));// 4 bytes
					System.out.println("\n");
				}
				break;
				
			case "ler_q":
				if (ProgramaIniciado(estado))
				{
					paginacao.LerQ(Integer.valueOf(parametro1));// 8 bytes
					System.out.println("\n");
				}
				break;
				
				
			case "escrever_b":
				if (ProgramaIniciado(estado))
				{	
					paginacao.EscreverB((byte)(int)Integer.valueOf(parametro1, 2), Integer.valueOf(parametro2)); // 1 byte
				}				
				break;
				
			case "escrever_w":
				if (ProgramaIniciado(estado))
				{
					String[] strBytes = parametro1.split("(?<=\\G........)");
					byte byte1 = (byte)(int)Integer.valueOf(strBytes[0], 2);
					byte byte2 = (byte)(int)Integer.valueOf(strBytes[1], 2);
					paginacao.EscreverW(new byte[]{byte1,byte2}, Integer.valueOf(parametro2)); // 2 bytes
				}
				break;
				
			case "escrever_l":
				if (ProgramaIniciado(estado))
				{
					String[] strBytes = parametro1.split("(?<=\\G........)");
					byte byte1 = (byte)(int)Integer.valueOf(strBytes[0], 2);
					byte byte2 = (byte)(int)Integer.valueOf(strBytes[1], 2);
					byte byte3 = (byte)(int)Integer.valueOf(strBytes[2], 2);
					byte byte4 = (byte)(int)Integer.valueOf(strBytes[3], 2);
					paginacao.EscreverL(new byte[]{byte1,byte2,byte3,byte4}, Integer.valueOf(parametro2));// 4 bytes
				}
				break;
				
			case "escrever_q":
				if (ProgramaIniciado(estado))
				{
					String[] strBytes = parametro1.split("(?<=\\G........)");
					byte byte1 = (byte)(int)Integer.valueOf(strBytes[0], 2);
					byte byte2 = (byte)(int)Integer.valueOf(strBytes[1], 2);
					byte byte3 = (byte)(int)Integer.valueOf(strBytes[2], 2);
					byte byte4 = (byte)(int)Integer.valueOf(strBytes[3], 2);
					byte byte5 = (byte)(int)Integer.valueOf(strBytes[4], 2);
					byte byte6 = (byte)(int)Integer.valueOf(strBytes[5], 2);
					byte byte7 = (byte)(int)Integer.valueOf(strBytes[6], 2);
					byte byte8 = (byte)(int)Integer.valueOf(strBytes[7], 2);
					paginacao.EscreverQ(new byte[]{byte1,byte2,byte3,byte4,byte5,byte6,byte7,byte8}, Integer.valueOf(parametro2));// 8 bytes
				}
				break;
							
			case "help":
				System.out.println("iniciar - avisar a aplicação que serão enviadas instruções fis, vir e leitura e escrita, serve para configurar a aplicação");
				System.out.println("finalizar - encerrar a aplicação e remover arquivo criado");
				System.out.println("fis [quantidade de páginas fisicas] [tamanho das páginas em bytes]- alocar em memória principal a quantidade de espaço especificada pelo número de bytes informado");
				System.out.println("vir [quantidade de páginas virtuais] [nome do arquivo] - cria o arquivo especificado com o tamanho necessário para armazenar a memória do sistema");
				System.out.println("ler_b [endereço] - leitura de 1 byte no endereço especificado");
				System.out.println("ler_w [endereço] - leitura de 2 bytes no endereço especificado");
				System.out.println("ler_l [endereço] - leitura de 4 bytes no endereço especificado");
				System.out.println("ler_q [endereço] - leitura de 8 bytes no endereço especificado");
				System.out.println("escrever_b [dado em byte] [endereço] - para escrita do dado de 1 byte no endereço especificado");
				System.out.println("escrever_w [2 bytes de dado(sem espaço)] [endereço] - para escrita do dado de 2 bytes no endereço especificado");
				System.out.println("escrever_l [4 bytes de dado(sem espaço)] [endereço] - para escrita do dado de 4 bytes no endereço especificado");
				System.out.println("escrever_q [8 bytes de dado(sem espaço)] [endereço] - para escrita do dado de 8 bytes no endereço especificado");
				break;
				
			default:
				System.out.println("Comando incorreto, digite 'help' para lista de comandos");
				break;
		}
		
		return estado;
	}
	
	public static boolean ProgramaIniciado(String estado)
	{
		if (estado.contentEquals("iniciar"))
		{
			return true;			
		}
		else 
		{
			System.out.println("Comando inválido, favor digite o comando 'iniciar' para começar");
			return false;			
		}		
	}
}
