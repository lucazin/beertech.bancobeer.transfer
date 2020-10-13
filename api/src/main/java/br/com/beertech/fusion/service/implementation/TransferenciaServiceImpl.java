package br.com.beertech.fusion.service.implementation;

import br.com.beertech.fusion.domain.operations.Operacao;
import br.com.beertech.fusion.domain.transfer.Transferencia;
import br.com.beertech.fusion.repository.TransferenciaRepository;
import br.com.beertech.fusion.service.interfaces.OperationService;
import br.com.beertech.fusion.service.interfaces.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private TransferenciaRepository TransferenciaRepository;

    @Autowired
    public TransferenciaServiceImpl(TransferenciaRepository operationRepository) {
        this.TransferenciaRepository = operationRepository;
    }

    @Override
    public Transferencia NovaTransferencia(Transferencia transfer,Operacao OperacaoTransfer,OperationService AutoOperationService) {

        AutoOperationService.NovaTransacao(OperacaoTransfer);
        return TransferenciaRepository.save(transfer);
    }

    @Override
    public List<Transferencia> ListaTransferencias() {
        return TransferenciaRepository.findAll();
    }

}
