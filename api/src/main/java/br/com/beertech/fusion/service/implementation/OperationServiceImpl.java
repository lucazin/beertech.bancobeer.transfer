package br.com.beertech.fusion.service.implementation;

import br.com.beertech.fusion.domain.operations.Operacao;
import br.com.beertech.fusion.domain.operations.OperationType;
import br.com.beertech.fusion.domain.operations.Saldo;
import br.com.beertech.fusion.repository.OperationRepository;
import br.com.beertech.fusion.service.interfaces.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    private OperationRepository operationRepository;

    @Autowired
    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public Operacao NovaTransacao(Operacao operacao) {
        return operationRepository.save(operacao);
    }


    @Override
    public List<Operacao> ListaTransacoes() {
        return operationRepository.findAll();
    }

    @Override
    public Saldo SaldoContaCorrente(Long Hash) {

        List<Operacao> OperacoesCC = this.operationRepository.findByHashContaCorrente(Hash);
        Double Deposito = OperacoesCC.stream()
                .filter(o -> OperationType.DEPOSITO.ID == o.getTipoOperacao())
                .mapToDouble(Operacao::getValorOperacao)
                .sum();
        Double Saque_Transferencia = OperacoesCC.stream()
                .filter(o -> OperationType.SAQUE.ID == o.getTipoOperacao() || OperationType.TRANSFERENCIA.ID == o.getTipoOperacao())
                .mapToDouble(Operacao::getValorOperacao)
                .sum();

        return new Saldo(Deposito - Saque_Transferencia);
    }

    @Override
    public void RemoveTransacao(Long idOperation) {
        operationRepository.delete(getOperationById(idOperation));
    }


    private Operacao getOperationById(Long idOperation) {
        return operationRepository.getOne(idOperation);
    }

}
