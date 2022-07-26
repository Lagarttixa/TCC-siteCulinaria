package com.tcc.siteculinariaapi.api.controller;

import com.tcc.siteculinariaapi.api.model.Usuario;
import com.tcc.siteculinariaapi.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity <Usuario> buscarPorId(@PathVariable Long usuarioId){
        return usuarioRepository.findById(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar(@Valid @RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> atualizar(@Valid @PathVariable Long usuarioId,
                                             @RequestBody Usuario usuario){
        if(!usuarioRepository.existsById(usuarioId)){
            return ResponseEntity.notFound().build();
        }

        usuario.setId(usuarioId);
        usuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> deletar(@PathVariable Long usuarioId){
        if(!usuarioRepository.existsById(usuarioId)){
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
