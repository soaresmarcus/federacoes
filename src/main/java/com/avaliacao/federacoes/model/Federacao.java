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
    public String nome;
    @Size(max = 2)
    @NotEmpty
    @NotNull
    public String sigla;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    public LocalDateTime dataRegistro;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    public LocalDateTime dataAtualizacao;
}
