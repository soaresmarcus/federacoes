package com.avaliacao.federacoes.model;

import com.avaliacao.federacoes.utils.LocalDateTimeAttributeConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Federacao extends AbstractEntity {
    @Size(max = 50)
    @NotEmpty
    @NotNull
    private String nome;
    @Size(max = 2)
    @NotEmpty
    @NotNull
    private String sigla;
    @NotNull
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime dataRegistro = LocalDateTime.now();
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime dataAtualizacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
