package main;

public class NoLista {
    NoLista proximoNo;
    long identificador;
    long memoriaAlocada;

    public NoLista(long memoria, NoLista noAnterior) {
        this.memoriaAlocada = memoria;
        if (noAnterior != null) {
            noAnterior.proximoNo = this;
            this.identificador = noAnterior.identificador + 1;
        }
        else {
        	this.identificador = 0;
        }
    }


    public long getValor() {
        return memoriaAlocada;
    }

    public String ToString() {
        return String.valueOf(memoriaAlocada);
    }

    public void setValor(int valor) {
        this.memoriaAlocada = valor;
    }

    public NoLista() {

    }
}