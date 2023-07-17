package com.example.CRUDUsuarios.service.implement;

import com.example.CRUDUsuarios.persistence.entity.Usuario;
import com.example.CRUDUsuarios.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsuarioServiceImplement implements UsuarioService{
    /**Formas de inyectar dependencias
     * 1.- Atributo
     * 2.- Constructor
     * 3.- Setter
     */
    private final UsuarioRepository usuarioRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        log.info("Buscando todos los Usuarios");
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Long Id) {
        return usuarioRepository.findById(Id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findByUserName(String userName) {
        return usuarioRepository.findByUserName(userName);
    }

    @Transactional
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public void deleteById(Long Id) {
        usuarioRepository.deleteById(Id);
    }
}
