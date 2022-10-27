package main;

public class PaginaVirtual {
	boolean disponivel;
	boolean sujo;
	int moldura;
	
	public PaginaVirtual(int moldura) {
		disponivel = true;
		sujo = false;
		this.moldura = moldura;
	}
}
