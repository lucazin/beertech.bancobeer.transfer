package br.com.beertech.fusion.service.interfaces;

import br.com.beertech.fusion.controller.dto.OperacaoDto;
import br.com.beertech.fusion.domain.operations.Operacao;
import br.com.beertech.fusion.domain.operations.Saldo;
import br.com.beertech.fusion.domain.transfer.Transferencia;

import java.util.List;

public interface TransferenciaService {

    Transferencia NovaTransferencia(Transferencia transfer,Operacao OperacaoTransfer,OperationService AutoOperationService);

    List<Transferencia> ListaTransferencias();

}
