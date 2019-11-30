package com.avaliacao.federacoes.controllers.enviar;

import com.avaliacao.federacoes.controllers.enviar.classes.DadosEnviar;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EnviaDados {

    public void enviaVariosDados(MockMvc mockMvc) throws Exception {
        DadosEnviar dadosEnviar = new DadosEnviar();
        ArrayList<String> retornos = new ArrayList();
        dadosEnviar.dadosIniciais().forEach(dado -> {
            String json = dado.toString();
            MvcResult sendReceive = null;
            try {
                sendReceive = mockMvc.perform(post("/federacoes")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                        .andExpect(status().isOk()).andReturn();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retornos.add(new String(sendReceive.getResponse().getContentAsByteArray()));
        });
    }
}