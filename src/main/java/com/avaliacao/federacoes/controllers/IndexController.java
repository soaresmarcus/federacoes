package com.avaliacao.federacoes.controllers;


import com.avaliacao.federacoes.model.Federacao;
import com.avaliacao.federacoes.services.FederacaoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = {"/{id}"})
    public Federacao listarById(@PathVariable("id") Long id) {
        return federacaoService.listarById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Federacao editar(@RequestBody Federacao federacao, @PathVariable("id") Long id) {
        federacao.setId(id);
        return federacaoService.editar(federacao);
    }

    @DeleteMapping(path = {"/{id}"})
    public Federacao excluir(@PathVariable("id") Long id) {
        return federacaoService.deletar(id);
    }
}
