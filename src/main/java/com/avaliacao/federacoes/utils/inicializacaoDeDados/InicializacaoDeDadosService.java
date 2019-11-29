package com.avaliacao.federacoes.utils.inicializacaoDeDados;

import com.avaliacao.federacoes.model.Permissao;
import com.avaliacao.federacoes.model.Usuario;
import com.avaliacao.federacoes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InicializacaoDeDadosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void adicionarUsuarioPadrao() {
        if (usuarioRepository.findByUsuario("marcus@marcus.com.br") == null) {
            Usuario usuario = usuarioPadrao();
            usuarioRepository.save(usuario);
        }
    }

    private Usuario usuarioPadrao() {
        Usuario usuario = new Usuario();
        usuario.usuario = "marcus@marcus.com.br";
        usuario.senha = new BCryptPasswordEncoder().encode("marcus");
        usuario.permissao = Permissao.ADMIN;
        return usuario;
    }
}
