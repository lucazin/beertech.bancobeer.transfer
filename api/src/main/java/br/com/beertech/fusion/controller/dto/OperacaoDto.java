package br.com.beertech.fusion.controller.dto;


import br.com.beertech.fusion.domain.operations.OperationType;

public class OperacaoDto {

    private OperationType tipoOperacao;
    private Double valorOperacao;
    private long hashContaCorrente;

    public OperacaoDto() {
    }
    
    public OperacaoDto(OperationType tipoOperacao, Double valorOperacao, long Hash) {
        this.tipoOperacao = tipoOperacao;
        this.valorOperacao = valorOperacao;
        this.hashContaCorrente = Hash;
    }


    public OperationType getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(OperationType tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(Double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public long getHashContaCorrente() {
        return hashContaCorrente;
    }

    public void setHashContaCorrente(long hashContaCorrente) {
        this.hashContaCorrente = hashContaCorrente;
    }
}
