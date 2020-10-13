package br.com.beertech.fusion.domain.transfer;

import br.com.beertech.fusion.controller.dto.TransferDto;
import br.com.beertech.fusion.util.Support;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "transferencia")
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idTransfer;

    private long hashTransfer;
    private String dataTransfer;

    @JsonIgnore
    private long hashOrigem;

    @JsonIgnore
    private long hashDestino;

    private Double valortransfer;


    public Transferencia() {
    }

    public Transferencia(TransferDto transferDto) {

        this.hashOrigem = transferDto.getHashOrigem();
        this.hashDestino = transferDto.getHashDestino();
        this.valortransfer = transferDto.getValorTransferido();

        this.dataTransfer =  new Support().getDataAtual();
        this.hashTransfer =  new Support().CreateHash256Sha(hashOrigem,hashDestino);
    }

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

    public Double getValortransfer() {
        return valortransfer;
    }

    public void setValortransfer(Double valortransfer) {
        this.valortransfer = valortransfer;
    }



    @Override
    public int hashCode() {
        return Objects.hash(idTransfer, hashOrigem, hashDestino,valortransfer);
    }

    public String getDataTransfer() {
        return dataTransfer;
    }

    public void setDataTransfer(String dataTransfer) {
        this.dataTransfer = dataTransfer;
    }

    public long getHashTransfer() {
        return hashTransfer;
    }

    public void setHashTransfer(long hashTransfer) {
        this.hashTransfer = hashTransfer;
    }
}
