package main;

public class PaginaFisica {
	int moldura;
	byte[] pagina;
	
	public PaginaFisica(int tamPagina) {
		moldura = 0;
		pagina = new byte[tamPagina];
	}
}
