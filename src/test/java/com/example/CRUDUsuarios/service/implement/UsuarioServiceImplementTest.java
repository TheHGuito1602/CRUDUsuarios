package com.example.CRUDUsuarios.service.implement;

import com.example.CRUDUsuarios.persistence.entity.Usuario;
import com.example.CRUDUsuarios.persistence.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioServiceImplementTest {
    @Autowired
    private UsuarioService usuarioService;
    @MockBean
    private UsuarioRepository usuarioRepository;
    @Test
    void whenFindAllUsers() {
        List<Usuario> responseList = new ArrayList<>();
        responseList.add(Usuario.builder().build());
        responseList.add(Usuario.builder().build());
        responseList.add(Usuario.builder().build());

        Mockito
                .when(usuarioRepository.findAll())
                .thenReturn(responseList);
        List<Usuario> usuarios = usuarioService.findAll();
        Mockito
                .verify(usuarioRepository, Mockito.times(1))
                .findAll();
        assertNotNull(usuarios);
        assertEquals(3,usuarios.size());
    }
}