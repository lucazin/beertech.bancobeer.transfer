package br.com.beertech.fusion.service.implementation;

import java.util.List;

import br.com.beertech.fusion.domain.operations.OperationType;
import org.springframework.stereotype.Service;

import br.com.beertech.fusion.controller.dto.OperacaoDto;
import br.com.beertech.fusion.domain.operations.Saldo;
import br.com.beertech.fusion.service.interfaces.SaldoService;

@Service
public class SaldoServiceImpl implements SaldoService {

    @Override
    public Saldo calcularSaldo(List<OperacaoDto> operacoes) {
        Double valorTotal = 0.0;
        if (operacoes != null && !operacoes.isEmpty())
        {
            Double depositos = operacoes.stream()
                    .filter(o -> OperationType.DEPOSITO.equals(o.getTipoOperacao()))
                    .mapToDouble(o -> o.getValorOperacao())
                    .sum();

            Double saques_transferencia = operacoes.stream()
                    .filter(o -> OperationType.SAQUE.equals(o.getTipoOperacao()) &&  OperationType.TRANSFERENCIA.equals(o.getTipoOperacao()))
                    .mapToDouble(o -> o.getValorOperacao())
                    .sum();

            valorTotal = depositos - saques_transferencia;
        }
        return new Saldo(valorTotal);
    }

}
