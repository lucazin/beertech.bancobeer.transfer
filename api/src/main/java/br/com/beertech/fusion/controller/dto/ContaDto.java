package br.com.beertech.fusion.controller.dto;

import br.com.beertech.fusion.domain.accounts.ContaType;

public class ContaDto {

    private ContaType tipoConta;

    private Double limiteLiberado;
    private String documentoTitular;
    private Long hashConta;

    public ContaDto() {
    }

    public ContaDto(ContaType tipoConta, Double limiteLiberado, String documentoTitular,Long Hash) {
        this.tipoConta = tipoConta;
        this.limiteLiberado = limiteLiberado;
        this.documentoTitular = documentoTitular;
        this.hashConta = Hash;
    }


    public ContaType getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(ContaType tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getLimiteLiberado() {
        return limiteLiberado;
    }

    public void setLimiteLiberado(Double limiteLiberado) {
        this.limiteLiberado = limiteLiberado;
    }

    public String getDocumentoTitular() {
        return documentoTitular;
    }

    public void setDocumentoTitular(String documentoTitular) {
        this.documentoTitular = documentoTitular;
    }

    public Long getHashConta() {
        return hashConta;
    }

    public void setHashConta(Long hashConta) {
        this.hashConta = hashConta;
    }

}
