package com.avaliacao.federacoes.controllers;


import com.avaliacao.federacoes.model.Federacao;
import com.avaliacao.federacoes.services.FederacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/federacoes"})
public class IndexController {

    @Autowired
    private FederacaoService federacaoService;

    @GetMapping()
    public List<Federacao> listar() {
        return federacaoService.listar();
    }
}
