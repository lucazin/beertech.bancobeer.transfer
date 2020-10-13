package br.com.beertech.fusion.domain;

import java.io.Serializable;
import java.util.Objects;


public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;

    private long hashOrigem;
    private long hashDestino;
    private Double valorTransferido;


    public Transferencia() { }

    public long getHashOrigem() {
        return hashOrigem;
    }

    public void setHashOrigem(long hashOrigem) {
        this.hashOrigem = hashOrigem;
    }

    public long getHashDestino() {
        return hashDestino;
    }

    public void setHashDestino(long hashDestino) {
        this.hashDestino = hashDestino;
    }

    public Double getValorTransferido() {
        return valorTransferido;
    }

    public void setValorTransferido(Double valorTransferido) {
        this.valorTransferido = valorTransferido;
    }



    @Override
    public int hashCode() {
        return Objects.hash(hashOrigem, hashDestino);
    }

}
