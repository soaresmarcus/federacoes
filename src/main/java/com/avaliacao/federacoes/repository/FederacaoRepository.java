package com.avaliacao.federacoes.repository;

import com.avaliacao.federacoes.model.Federacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FederacaoRepository extends JpaRepository<Federacao, Long> {
    Federacao findByNomeAndSigla(String nome, String sigla);
}
