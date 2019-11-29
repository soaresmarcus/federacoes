package com.avaliacao.federacoes.services;

import com.avaliacao.federacoes.model.Federacao;
import com.avaliacao.federacoes.repository.FederacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FederacaoService {
    @Autowired
    private FederacaoRepository federacaoRepository;

    public void salvaFederacao(Federacao federacao) {
        federacao.setDataRegistro(LocalDateTime.now());
        federacaoRepository.save(federacao);
    }
}
