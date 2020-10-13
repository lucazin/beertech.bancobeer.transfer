package br.com.beertech.fusion.controller.rest;

import br.com.beertech.fusion.controller.dto.ContaDto;
import br.com.beertech.fusion.controller.dto.OperacaoDto;
import br.com.beertech.fusion.domain.operations.Operacao;
import br.com.beertech.fusion.domain.operations.Saldo;
import br.com.beertech.fusion.service.interfaces.OperationService;
import br.com.beertech.fusion.service.interfaces.SaldoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/bankbeer")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private SaldoService saldoService;

    @GetMapping("/transacoes")
    public List<Operacao> listOperations() {
        return operationService.ListaTransacoes();
    }

    @GetMapping("/saldototal")
    public ResponseEntity<Saldo> listSaldo() {
        try
        {
            List<Operacao> transacoes = operationService.ListaTransacoes();
            Saldo Saldo = saldoService.calcularSaldo(
                    transacoes.stream().map(Operacao::getOperacaoDto).collect(Collectors.toList()));
            return new ResponseEntity<>(Saldo, OK);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @GetMapping("/saldocc")
    public  ResponseEntity<Saldo>  getSaldoCC(@RequestBody ContaDto ContaDtoCliente) {
        try
        {
            Saldo SaldoCC = operationService.SaldoContaCorrente(ContaDtoCliente.getHashConta());
            return new ResponseEntity<>(SaldoCC, OK);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Async("threadPoolTaskExecutor")
    @PostMapping("/operacao")
    public CompletableFuture<ResponseEntity<Operacao>> saveOperations(@RequestBody OperacaoDto operacaoDto) {
        Operacao operacao = new Operacao(operacaoDto);
        return CompletableFuture.completedFuture(new ResponseEntity<>(operationService.NovaTransacao(operacao), CREATED));
    }
}
