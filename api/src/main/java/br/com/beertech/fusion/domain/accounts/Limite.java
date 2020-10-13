package br.com.beertech.fusion.domain.accounts;

import java.io.Serializable;
import java.util.Objects;

public class Limite implements Serializable {

	private static final long serialVersionUID = 1L;

    public Limite(Double limite) {
        this.limiteAprovado = limite;
    }

	private Double limiteAprovado;

    @Override
    public int hashCode() {
        return Objects.hash(limiteAprovado);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj instanceof Limite && limiteAprovado.equals(((Limite) obj).getLimiteAprovado()));
    }

    public Double getLimiteAprovado() {
        return limiteAprovado;
    }

    public void setLimiteAprovado(Double limiteAprovado) {
        this.limiteAprovado = limiteAprovado;
    }
}
