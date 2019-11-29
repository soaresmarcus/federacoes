package com.avaliacao.federacoes.controllers;


import com.avaliacao.federacoes.model.Federacao;
import com.avaliacao.federacoes.repository.FederacaoRepository;
import com.avaliacao.federacoes.services.FederacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private FederacaoRepository federacaoRepository;
    @Autowired
    private FederacaoService federacaoService;

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("federacoesLista", federacaoRepository.findAll());
        modelAndView.addObject(new Federacao() {{
            setDataRegistro(LocalDateTime.now());
        }});
        return modelAndView;
    }

    @PostMapping(value = "/salvar")
    public ModelAndView salvaFederacao(@Valid @ModelAttribute Federacao federacao,
                                       BindingResult result,
                                       HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            return new ModelAndView("redirect:/?error");
        }
        federacaoService.salvaFederacao(federacao);

        List<Federacao> listaFederacoes = federacaoRepository.findAll();
        modelAndView.addObject("federacoesLista", listaFederacoes);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
