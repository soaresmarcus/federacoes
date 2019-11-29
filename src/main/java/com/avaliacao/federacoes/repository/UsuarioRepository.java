package com.avaliacao.federacoes.repository;

import com.avaliacao.federacoes.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
}
