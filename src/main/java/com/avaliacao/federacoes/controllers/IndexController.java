package com.avaliacao.federacoes.controllers;


import com.avaliacao.federacoes.model.Federacao;
import com.avaliacao.federacoes.services.FederacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/federacoes"})
public class IndexController {

    @Autowired
    private FederacaoService federacaoService;

    @GetMapping
    public List<Federacao> listar() {
        return federacaoService.listar();
    }

    @PostMapping
    public Federacao salvar(@RequestBody Federacao federacao) {
        return federacaoService.add(federacao);
    }
}
