package br.com.beertech.fusion.service.implementation;

import br.com.beertech.fusion.domain.accounts.Contacorrente;
import br.com.beertech.fusion.repository.ContaCorrenteRepository;
import br.com.beertech.fusion.service.interfaces.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    private ContaCorrenteRepository ContaCorrenteRepository;

    @Autowired
    public ContaCorrenteServiceImpl(ContaCorrenteRepository ccRepository) {
        this.ContaCorrenteRepository = ccRepository;
    }

    @Override
    public Contacorrente NovaConta(Contacorrente cc) {
        return ContaCorrenteRepository.save(cc);
    }

    @Override
    public List<Contacorrente> ListaContas() {
        return ContaCorrenteRepository.findAll();
    }

    @Override
    public Contacorrente GetConta(Long Hash) {
        return ContaCorrenteRepository.getOne(Hash);
    }



    @Override
    public void RemoveConta(Long IdConta) {
        ContaCorrenteRepository.delete(ContaCorrenteRepository.getOne(IdConta));
    }

}
