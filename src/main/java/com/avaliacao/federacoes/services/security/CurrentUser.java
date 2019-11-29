package com.avaliacao.federacoes.services.security;

import com.avaliacao.federacoes.model.Permissao;
import com.avaliacao.federacoes.model.Usuario;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

    private Usuario usuario;

    public CurrentUser(Usuario usuario) {
        super(usuario.usuario, usuario.senha, AuthorityUtils.createAuthorityList(usuario.permissao.toString()));
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Permissao getRole() {
        return usuario.permissao;
    }

}
