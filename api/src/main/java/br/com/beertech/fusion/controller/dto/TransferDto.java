package br.com.beertech.fusion.controller.dto;

public class TransferDto {


    private Double valorTransferido;
    private Long hashOrigem;
    private Long hashDestino;

    public TransferDto() {
    }

    public TransferDto(Double valorTransferido, Long hashOrigem, Long hashDestino) {
        this.valorTransferido = valorTransferido;
        this.hashOrigem = hashOrigem;
        this.hashDestino = hashDestino;
    }


    public Long getHashDestino() {
        return hashDestino;
    }

    public void setHashDestino(Long hashDestino) {
        this.hashDestino = hashDestino;
    }

    public Double getValorTransferido() {
        return valorTransferido;
    }

    public void setValorTransferido(Double valorTransferido) {
        this.valorTransferido = valorTransferido;
    }

    public Long getHashOrigem() {
        return hashOrigem;
    }

    public void setHashOrigem(Long hashOrigem) {
        this.hashOrigem = hashOrigem;
    }
}
