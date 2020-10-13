package br.com.beertech.fusion.controller.rest;

import br.com.beertech.fusion.controller.dto.OperacaoDto;
import br.com.beertech.fusion.controller.dto.TransferDto;
import br.com.beertech.fusion.domain.operations.Operacao;
import br.com.beertech.fusion.domain.operations.OperationType;
import br.com.beertech.fusion.domain.transfer.Transferencia;
import br.com.beertech.fusion.service.interfaces.OperationService;
import br.com.beertech.fusion.service.interfaces.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/bankbeertransfer")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferservice;

    @Autowired
    private OperationService transferOperationValueService;


    @GetMapping("/list")
    public List<Transferencia> listOperations() {
        return transferservice.ListaTransferencias();
    }

    @Async("threadPoolTaskExecutor")
    @PostMapping("/newtransfer")
    public CompletableFuture<ResponseEntity<Transferencia>> saveTransfer(@RequestBody TransferDto transferenciaDTO)
    {
        Operacao OperationTransfer = new Operacao(new OperacaoDto(OperationType.TRANSFERENCIA,
                transferenciaDTO.getValorTransferido(),
                transferenciaDTO.getHashOrigem()
        ));

        Transferencia transfer = new Transferencia(transferenciaDTO);
        return CompletableFuture.completedFuture(new ResponseEntity<>(transferservice.NovaTransferencia(transfer, OperationTransfer, transferOperationValueService), CREATED));
    }

}
