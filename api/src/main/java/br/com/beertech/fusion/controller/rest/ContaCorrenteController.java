package br.com.beertech.fusion.controller.rest;

import br.com.beertech.fusion.controller.dto.ContaDto;
import br.com.beertech.fusion.domain.accounts.Contacorrente;
import br.com.beertech.fusion.domain.accounts.Limite;
import br.com.beertech.fusion.service.interfaces.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/bankbeerAccount")
public class ContaCorrenteController {

    @Autowired
    private ContaCorrenteService ContaBancariaService;


    @GetMapping("/contas")
    public List<Contacorrente> listOperations() {
        return ContaBancariaService.ListaContas();
    }

    @GetMapping("/limite")
    public ResponseEntity<Limite> listlimite(@RequestBody ContaDto ContaDtoCliente) {
        try
        {
            Contacorrente contacorrente = ContaBancariaService.GetConta(ContaDtoCliente.getHashConta());
            Limite LimiteCliente = new Limite(contacorrente.getLimiteLiberado());
            return new ResponseEntity<>(LimiteCliente, OK);
        }
        catch (Exception e)
        {
            throw e;
        }
    }


    @Async("threadPoolTaskExecutor")
    @PostMapping("/novaconta")
    public CompletableFuture<ResponseEntity<Contacorrente>> saveOperations(@RequestBody ContaDto ContaDtoCliente) {
        Contacorrente contaCliente = new Contacorrente(ContaDtoCliente);
        return CompletableFuture.completedFuture(new ResponseEntity<>(ContaBancariaService.NovaConta(contaCliente), CREATED));
    }


}
