package com.example.CRUDUsuarios.service.implement;

import com.example.CRUDUsuarios.persistence.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long Id);
    Optional<Usuario> findByUserName(String userName);
    Usuario save(Usuario usuario);

    void deleteById(Long Id);
}
