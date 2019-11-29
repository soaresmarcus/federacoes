package com.avaliacao.federacoes.controllers;


import com.avaliacao.federacoes.model.Federacao;
import com.avaliacao.federacoes.repository.FederacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private FederacaoRepository federacaoRepository;

    @GetMapping("/")
    public ModelAndView index() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("index");
        List<Federacao> federacoesLista = federacaoRepository.findAll();
        modelAndView.addObject("federacoesLista", federacoesLista);
       return modelAndView;
    }
}
