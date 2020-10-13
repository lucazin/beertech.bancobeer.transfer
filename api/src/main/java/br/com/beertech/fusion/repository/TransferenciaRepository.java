package br.com.beertech.fusion.repository;

import br.com.beertech.fusion.domain.accounts.Contacorrente;
import br.com.beertech.fusion.domain.transfer.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
