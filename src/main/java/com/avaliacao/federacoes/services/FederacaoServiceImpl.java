package com.avaliacao.federacoes.services;

import com.avaliacao.federacoes.model.Federacao;
import com.avaliacao.federacoes.repository.FederacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FederacaoServiceImpl implements FederacaoService {
    @Autowired
    private FederacaoRepository federacaoRepository;

    @Override
    public Federacao add(Federacao federacao) {
        federacao.setDataRegistro(LocalDateTime.now());
        federacaoRepository.save(federacao);
        return federacao;
    }

    @Override
    public List<Federacao> listar() {
        return federacaoRepository.findAll();
    }

    @Override
    public Federacao listarId(Long id) {
        return federacaoRepository.findOneById(id);
    }

    @Override
    public Federacao editar(Federacao federacao) {
        return null;
    }

    @Override
    public Federacao deletar(Long id) {
        return null;
    }
}
