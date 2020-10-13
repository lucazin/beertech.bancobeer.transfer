package br.com.beertech.fusion.service.interfaces;

import java.util.List;

import br.com.beertech.fusion.controller.dto.OperacaoDto;
import br.com.beertech.fusion.domain.operations.Saldo;

public interface SaldoService {

    Saldo calcularSaldo(List<OperacaoDto> operacoes);
}
