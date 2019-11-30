package com.avaliacao.federacoes.services;

import com.avaliacao.federacoes.model.Federacao;

import java.util.List;

public interface FederacaoService {
    List<Federacao>listar();
    Federacao listarId(Long id);
    Federacao add(Federacao federacao);
    Federacao editar(Federacao federacao);
    Federacao deletar(Long id);
}
