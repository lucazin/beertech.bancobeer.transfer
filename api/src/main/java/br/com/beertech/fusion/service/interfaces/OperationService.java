package br.com.beertech.fusion.service.interfaces;

import br.com.beertech.fusion.domain.operations.Operacao;
import br.com.beertech.fusion.domain.operations.Saldo;

import java.util.List;

public interface OperationService {

    Operacao NovaTransacao(Operacao operacao);

    void RemoveTransacao(Long idBeer);

    List<Operacao> ListaTransacoes();

    Saldo SaldoContaCorrente(Long Hash);
}
