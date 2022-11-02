package main;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Paginacao {

	int tamPagina = 0;
	int nPagVirtuais = 0;
	int nPagReais = 0;
	PaginaVirtual paginasVirtuais[] = null;
	PaginaFisica memoriaFisica[] = null;
	RandomAccessFile memoriaVirtual = null;

	public Paginacao(int tamPagina, int nPagVirtuais, int nPagReais, String nomeArquivo) {
		this.tamPagina = tamPagina;
		this.nPagVirtuais = nPagVirtuais;
		this.nPagReais = nPagReais;
		paginasVirtuais = new PaginaVirtual[nPagVirtuais];
		memoriaFisica = new PaginaFisica[nPagReais];

		for (int i = 0; i < nPagReais; i++) {
			memoriaFisica[i] = new PaginaFisica(tamPagina);
			memoriaFisica[i].moldura = i;
		}
		
		for (int i = 0; i < nPagVirtuais; i++) {
			paginasVirtuais[i] = new PaginaVirtual(nPagReais+i);
		}
		
		criaArquivo(tamPagina * nPagVirtuais, nomeArquivo);
	}

	public void criaArquivo(long tam, String nomeArquivo) { 					// CRIA ARQUIVO DE ACORDO COM NOME INSERIDO E
		try { 																	// E IMPLEMENTADO FOR PARA PREENCHER COM 0's DE
			memoriaVirtual = new RandomAccessFile(nomeArquivo + ".bin", "rw");  // ACORDO COM TAMANHO INSERIDO
			for (long i = 0; i < tam; i++) {
				memoriaVirtual.writeByte(0);
			}
			System.out.println("... Arquivo Criado com Sucesso ! ...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void carregarPaginaVirtual(int nPagReal, int nPagVirtual) { 			// Carrega pagina virtual na pagina real
		try {																	// CARREGA 
			memoriaVirtual.seek(nPagVirtual * tamPagina);
			memoriaVirtual.read(memoriaFisica[nPagReal].pagina, 0, tamPagina);
			paginasVirtuais[nPagVirtual].moldura = nPagReal;
			paginasVirtuais[nPagVirtual].sujo = false;
			paginasVirtuais[nPagVirtual].disponivel = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Salvar no Arquivo virtual pagina real
	public void salvarPaginaVirtual(int nPagReal, int nPagVirtual) {
		if (paginasVirtuais[nPagVirtual].sujo) {
			try {
				memoriaVirtual.seek(nPagVirtual * tamPagina);
				memoriaVirtual.write(memoriaFisica[nPagReal].pagina, 0, tamPagina);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		paginasVirtuais[nPagVirtual].moldura = -1;
		paginasVirtuais[nPagVirtual].sujo = false;
		paginasVirtuais[nPagVirtual].disponivel = false;
	}

	public void EscreverB(byte dado, int endereco) {
		
		int moldura = endereco/tamPagina;
		int offset = endereco%tamPagina;

		// tenta encontrar na memoria física
		for (int i = 0; i < nPagReais; i++) {
			if (memoriaFisica[i].moldura == moldura) {				
				memoriaFisica[i].pagina[offset] = dado;				
				return;
			}
		}
		// se nao estiver a moldura na real, tenta escrever na virtual
		try {
			for (int i = 0; i < paginasVirtuais.length; i++) {
				if (paginasVirtuais[i].moldura == moldura) {
					memoriaVirtual.seek((i * tamPagina)+offset);
					memoriaVirtual.writeByte(dado);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void LerB(int endereco) {
		// String bin = String.valueOf(Long.toString(Long.parseLong(enderecoHex, 16),
		// 2));//hex para bin

		int moldura = endereco/tamPagina;
		int offset = endereco%tamPagina;

		//memoriaFisica.procurarMoldura();
		
		// procurar moldura na fisica
		for (int i = 0; i < nPagReais; i++) {
			if (memoriaFisica[i].moldura == moldura) {		
					System.out.print(Integer.toBinaryString(memoriaFisica[i].pagina[offset]));
				return;
			}
		}

		// se nao procurar moldura na virtual
		for (int i = 0; i < paginasVirtuais.length; i++) {
			// se achar, salvar na fisica(random)
			if (paginasVirtuais[i].moldura == moldura) {
				// valor random para salvar na fisica
				int random = (int) (Math.random() * nPagReais);
				// seta a pagina como disponível
				paginasVirtuais[i].disponivel = true;
				int emUso = 0;
				// achar pagina virtual para salvar o valor da pagina de moldura random
				for (int j = 0; j < paginasVirtuais.length; j++) {
					if (paginasVirtuais[j].disponivel) {
						salvarPaginaVirtual(random, j);
						// carregarPaginaVirtual(i, random)
						carregarPaginaVirtual(random, i);		
							String binario = Integer.toBinaryString(memoriaFisica[random].pagina[offset]);
							System.out.print(binario);						
						return;						
					}
				}
				System.out.println("Não há disponibilidade...");
				return;
			}
		}

		// se nao encontrar avisa
		System.out.println("null");
	}	
	
	public void LerW(Integer endereco) {
		LerB(endereco);
		System.out.print(",");		
		LerB(endereco+1);
	}
	
	public void LerL(Integer endereco) {
		LerW(endereco);
		System.out.print(",");		
		LerW(endereco+2);		
	}
	
	public void LerQ(Integer endereco) {
		LerL(endereco);
		System.out.print(",");		
		LerL(endereco+4);
	}
	
	public void EscreverW(byte[] dados, Integer endereco) {
		int i = 0;
		for(byte dado : dados){
			EscreverB(dado, endereco+i);
			i++;
		}
	}

	public void EscreverL(byte[] dados, Integer endereco) {
		int i = 0;
		for(byte dado : dados){
			EscreverB(dado, endereco+i);
			i++;
		}
	}

	public void EscreverQ(byte[] dados, Integer endereco) {
		int i = 0;
		for(byte dado : dados){
			EscreverB(dado, endereco+i);
			i++;
		}
	}
}
