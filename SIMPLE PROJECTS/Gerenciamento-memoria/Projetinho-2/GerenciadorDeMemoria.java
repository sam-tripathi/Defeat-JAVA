package main;

public class GerenciadorDeMemoria {
	
	public static void main(String[] args) {
		
		Lista lista = new Lista();
		lista.configurar(10);
		System.out.println(lista.memoriaLivre());
		System.out.println(lista.memoriaOcupada());
		lista.alocar(5);
		long id = lista.alocar(2);
		System.out.println(lista.memoriaLivre());
		System.out.println(lista.memoriaOcupada());
	}
}
