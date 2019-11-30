package com.avaliacao.federacoes.controllers;

import com.avaliacao.federacoes.FederacoesApplicationTests;
import com.avaliacao.federacoes.controllers.enviar.EnviaDados;
import com.avaliacao.federacoes.model.Federacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IndexControllerTest extends FederacoesApplicationTests {
    @Autowired
    private IndexController indexController;

    @Test
    void salvar(){
        Federacao federacao = new Federacao();
        federacao.setNome("Tarsila Unidade");
        federacao.setSigla("A1");
        indexController.salvar(federacao);

        federacao = new Federacao();
        federacao.setNome("Camila Unidade");
        federacao.setSigla("A8");
        indexController.salvar(federacao);

        assertEquals(indexController.listarById(1L).getNome(), "Tarsila Unidade");
        assertEquals(indexController.listarById(1L).getSigla(), "A1");
        assertEquals(indexController.listarById(2L).getNome(), "Camila Unidade");
        assertEquals(indexController.listarById(2L).getSigla(), "A8");
    }

    @Test
    void listar() throws Exception {
        assertTrue(federacaoRepository.count() == indexController.listar().size());
        enviaDadosIniciais();
        assertTrue(federacaoRepository.count() == indexController.listar().size());
    }

    @Test
    void listarById() throws Exception {
        enviaDadosIniciais();
        assertEquals(indexController.listarById(1L).getNome(), "Tarsila Unidade");
        assertEquals(indexController.listarById(1L).getSigla(), "A1");
        assertEquals(indexController.listarById(8L).getNome(), "Camila Unidade");
        assertEquals(indexController.listarById(8L).getSigla(), "A8");
    }

    @Test
    void editar() throws Exception {
        enviaDadosIniciais();
        Federacao unidade = indexController.listarById(1L);
        unidade.setNome("Minas Gerais");
        unidade.setSigla("MG");
        indexController.editar(unidade, 1L);
        assertEquals(federacaoRepository.findById(1L).get().getNome(), "Minas Gerais");
        assertEquals(federacaoRepository.findById(1L).get().getSigla(), "MG");
    }

    @Test
    void excluir() throws Exception {
        enviaDadosIniciais();
        indexController.excluir(1L);
        indexController.excluir(2L);
        indexController.excluir(3L);
        indexController.excluir(4L);
        indexController.excluir(7L);
        indexController.excluir(8L);
        assertTrue(federacaoRepository.count() == 2);
    }

    public void enviaDadosIniciais() throws Exception {
        new EnviaDados().enviaVariosDados(mockMvc);
    }
}