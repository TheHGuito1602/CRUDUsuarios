package com.example.CRUDUsuarios.controller;

import com.example.CRUDUsuarios.persistence.entity.Usuario;
import com.example.CRUDUsuarios.service.implement.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    /**
     * GET
     * DELETE
     * POST
     * PUT
     */

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable long id){
        return usuarioService
                .findById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return Optional
                .of(usuarioService.save(usuario))
                .map(usuario1 -> ResponseEntity
                        .created(URI.create("/api/usuarios/" + usuario1.getId()))
                        .body(usuario1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
