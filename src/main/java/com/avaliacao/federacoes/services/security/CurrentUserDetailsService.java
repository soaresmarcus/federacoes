package com.avaliacao.federacoes.services.security;

import com.avaliacao.federacoes.model.Usuario;
import com.avaliacao.federacoes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsuario(usuario);
        if (user == null)
            throw new UsernameNotFoundException(String.format("Usuário não encontrado", usuario));
        return new CurrentUser(user);
    }
}
