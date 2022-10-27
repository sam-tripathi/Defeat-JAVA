package main;

public class Lista {
    NoLista primeiro;
    NoLista ponteiro;
    long memoriaDisponivel;

    public Lista() {
        primeiro = null;
    }

    public void configurar(long tamanhoMemoria) {
        this.memoriaDisponivel = tamanhoMemoria;
    }
    
    public long alocar(long quantidade) {
    	if (quantidade <= memoriaLivre())
    	{
            if (primeiro == null) {
                NoLista primeiroNo = new NoLista(quantidade, null);
                primeiro = primeiroNo;
                ponteiro = primeiro;
            }
            else {
            	NoLista no = new NoLista(quantidade, ponteiro);
                ponteiro = no;
            }  
            return ponteiro.identificador;
    	}       
    	return -1;
    }
    
    public void desalocar(long identificador) {
        ponteiro = primeiro;
        NoLista antes = null;
        NoLista retirar = null;
        while (ponteiro != null) {
            if (ponteiro.identificador == identificador) {
                retirar = ponteiro;
                if (retirar.proximoNo != null)
                {
                	antes.proximoNo = retirar.proximoNo;
                }
                retirar.memoriaAlocada = 0;
                retirar.proximoNo = null;
                ponteiro = null;
            } else {
                antes = ponteiro;
                ponteiro = ponteiro.proximoNo;
            }
        }
    }
    
    public long memoriaOcupada() { 
    	return memoriaOcupadaAux(primeiro, 0);
    }
    
    private long memoriaOcupadaAux(NoLista noLista, long memoriaTotal) { 
    	if (noLista != null)
    	{
    		long memoriaUsada = memoriaTotal + noLista.memoriaAlocada;
    		memoriaTotal = memoriaOcupadaAux(noLista.proximoNo, memoriaUsada);
    	}    	
    	return memoriaTotal;
    }
    
    public long memoriaLivre() {
        return memoriaDisponivel - memoriaOcupada();
    }
    
    public void imprime() {
        this.ponteiro = primeiro;
        while (ponteiro != null) {
            System.out.print(ponteiro.memoriaAlocada + " ");
            this.ponteiro = ponteiro.proximoNo;
        }
        System.out.println("");
    }

    private void imprimeRecursivoAux(NoLista noLista) {
        if (noLista != null) {
            System.out.print(noLista.memoriaAlocada);
            imprimeRecursivoAux(noLista.proximoNo);
        }
    }

    public void imprimeRecursivo() {
        System.out.print("RECURSIVO: ");
        imprimeRecursivoAux(primeiro);
        System.out.println("");
    }
}