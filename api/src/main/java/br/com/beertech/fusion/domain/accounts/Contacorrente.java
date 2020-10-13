package br.com.beertech.fusion.domain.accounts;

import br.com.beertech.fusion.controller.dto.ContaDto;
import br.com.beertech.fusion.util.Support;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "contacorrente")
public class Contacorrente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonIgnore
    private Long idConta;

    private String dataCriacao;
    private String documentoTitular;
    private int tipoConta;
    private Double limiteLiberado;

    private Long hashConta;


    public Contacorrente() {
    }

    public Contacorrente(ContaDto contacorrenteDto) {

        this.tipoConta = contacorrenteDto.getTipoConta().ID;
        this.documentoTitular = contacorrenteDto.getDocumentoTitular();
        this.limiteLiberado = contacorrenteDto.getLimiteLiberado();

        this.dataCriacao = new Support().getDataAtual();
        this.hashConta =  new Support().CreateHash256Sha(this.documentoTitular);
    }

    @JsonIgnore
    public ContaDto getContaDto() {
        return new ContaDto(ContaType.getById(this.tipoConta), this.limiteLiberado,this.documentoTitular,this.hashConta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConta, documentoTitular, tipoConta,hashConta);
    }




    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDocumentoTitular() {
        return documentoTitular;
    }

    public void setDocumentoTitular(String documentoTitular) {
        this.documentoTitular = documentoTitular;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getLimiteLiberado() {
        return limiteLiberado;
    }

    public void setLimiteLiberado(Double limiteLiberado) {
        this.limiteLiberado = limiteLiberado;
    }

    public Long getHashConta() {
        return hashConta;
    }

    public void setHashConta(Long hashConta) {
        this.hashConta = hashConta;
    }

}
