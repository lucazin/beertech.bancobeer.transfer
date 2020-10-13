package br.com.beertech.fusion.service.interfaces;

import br.com.beertech.fusion.domain.accounts.Contacorrente;

import java.util.List;

public interface ContaCorrenteService {

    Contacorrente NovaConta(Contacorrente cc);

    void RemoveConta(Long idConta);

    List<Contacorrente> ListaContas();

    Contacorrente GetConta(Long Hash);


}
