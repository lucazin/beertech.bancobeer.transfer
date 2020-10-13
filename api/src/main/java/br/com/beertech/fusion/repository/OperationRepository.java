package br.com.beertech.fusion.repository;

import br.com.beertech.fusion.domain.operations.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operacao, Long> {
    List<Operacao> findByHashContaCorrente(long HashReceived);
}
