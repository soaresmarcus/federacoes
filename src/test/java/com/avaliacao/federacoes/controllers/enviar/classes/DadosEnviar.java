package com.avaliacao.federacoes.controllers.enviar.classes;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DadosEnviar {

    public ArrayList<JSONObject> dados;

    public ArrayList<JSONObject> dadosIniciais() throws JSONException {
        dados = new ArrayList<>();

        // indice 0
        dados.add(new JSONObject() {{
            put("nome", "Tarsila Unidade");
            put("sigla", "A1");
            put("dataAtualizacao", LocalDateTime.now().toString());
        }});

        // indice 1
        dados.add(new JSONObject() {{
            put("nome", "Josefa Unidade");
            put("sigla", "A2");
            put("dataAtualizacao", LocalDateTime.now().toString());
        }});

        // indice 2
        dados.add(new JSONObject() {{
            put("nome", "Pedro Unidade");
            put("sigla", "A3");
            put("dataAtualizacao", LocalDateTime.now().toString());
        }});

        // indice 3
        dados.add(new JSONObject() {{
            put("nome", "Humberto Unidade");
            put("sigla", "A4");
            put("dataAtualizacao", LocalDateTime.now().toString());
        }});

        // indice 4
        dados.add(new JSONObject() {{
            put("nome", "Rodrigo Unidade");
            put("sigla", "A5");
            put("dataAtualizacao", LocalDateTime.now().toString());
        }});

        // indice 5
        dados.add(new JSONObject() {{
            put("nome", "Maria Unidade");
            put("sigla", "A6");
            put("dataAtualizacao", LocalDateTime.now().toString());
        }});

        // indice 6
        dados.add(new JSONObject() {{
            put("nome", "Rita Unidade");
            put("sigla", "A7");
            put("dataAtualizacao", LocalDateTime.now().toString());
        }});

        // indice 7
        dados.add(new JSONObject() {{
            put("nome", "Camila Unidade");
            put("sigla", "A8");
            put("dataAtualizacao", LocalDateTime.now().toString());
        }});
        return dados;
    }


}
