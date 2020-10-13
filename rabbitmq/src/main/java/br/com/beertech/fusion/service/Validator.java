package br.com.beertech.fusion.service;

import br.com.beertech.fusion.domain.Operacao;
import br.com.beertech.fusion.domain.Transferencia;

public class Validator {

    Operacao ObjectValidatorOperation;
    Transferencia ObjectValidatorTransferencia;

    public Validator(Operacao ObjectValidatorParameter)
    {
        ObjectValidatorOperation = ObjectValidatorParameter;
    }
    public Validator(Transferencia ObjectValidatorParameter)
    {
        ObjectValidatorTransferencia = ObjectValidatorParameter;
    }

    public boolean ValidateOperationResponseRMQ()
    {
        boolean passed = false;

        if(ObjectValidatorOperation.getTipoOperacao().equals("DEPOSITO") || ObjectValidatorOperation.getTipoOperacao().equals("SAQUE"))
        {
            if(ObjectValidatorOperation.getValorOperacao() > 0)
                passed = true;
        }

        return passed;
    }
    public boolean ValidateTransferResponseRMQ()
    {
        boolean passed = false;

        if(ObjectValidatorTransferencia.getHashOrigem() > 0 || ObjectValidatorTransferencia.getHashDestino() > 0)
        {
            if(ObjectValidatorTransferencia.getValorTransferido() > 0)
                passed = true;
        }

        return passed;
    }
}
