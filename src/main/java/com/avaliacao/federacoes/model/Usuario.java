package com.avaliacao.federacoes.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends AbstractEntity {
    @Column(nullable = false, unique = true)
    public String usuario;
    @Column(nullable = false)
    public String senha;
    @Column(nullable = false)
    public Permissao permissao = Permissao.USUARIO;

    public Usuario() {
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = new BCryptPasswordEncoder().encode(senha);
    }
}
