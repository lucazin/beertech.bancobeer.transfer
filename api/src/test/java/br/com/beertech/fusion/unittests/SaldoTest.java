package br.com.beertech.fusion.unittests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import br.com.beertech.fusion.domain.operations.OperationType;
import org.junit.jupiter.api.Test;

import br.com.beertech.fusion.controller.dto.OperacaoDto;

import br.com.beertech.fusion.domain.operations.Saldo;
import br.com.beertech.fusion.service.interfaces.SaldoService;
import br.com.beertech.fusion.service.implementation.SaldoServiceImpl;

public class SaldoTest {

    @Test
    void testaSaldoDeposito() {
        List<OperacaoDto> operacoes = new ArrayList<>();
        operacoes.add(new OperacaoDto(OperationType.DEPOSITO, 100.,0));
        SaldoService saldoService = new SaldoServiceImpl();
        assertEquals(saldoService.calcularSaldo(operacoes), new Saldo(100.));
    }

    @Test
    void testaSaldoSaque() {
        List<OperacaoDto> operacoes = new ArrayList<>();
        operacoes.add(new OperacaoDto(OperationType.SAQUE, 10.,0));
        SaldoService saldoService = new SaldoServiceImpl();
        assertEquals(saldoService.calcularSaldo(operacoes), new Saldo(-10.));
    }

    @Test
    void testaSaldoOperacoesVariadas() {
        List<OperacaoDto> operacoes = new ArrayList<>();
        operacoes.add(new OperacaoDto(OperationType.DEPOSITO, 100.,0));
        operacoes.add(new OperacaoDto(OperationType.SAQUE, 25.,0));
        operacoes.add(new OperacaoDto(OperationType.SAQUE, 10.,0));
        SaldoService saldoService = new SaldoServiceImpl();
        assertEquals(saldoService.calcularSaldo(operacoes), new Saldo(65.));
    }

    @Test
    void testaSaldoSemOperacoes() {
        List<OperacaoDto> operacoes = new ArrayList<>();
        SaldoService saldoService = new SaldoServiceImpl();
        assertEquals(saldoService.calcularSaldo(operacoes), new Saldo(0.));
    }
}
