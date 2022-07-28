package com.tcc.siteculinariaapi.api.service;

import com.tcc.siteculinariaapi.api.exception.DomainException;
import com.tcc.siteculinariaapi.api.model.Usuario;
import com.tcc.siteculinariaapi.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        boolean telefoneEmUso = usuarioRepository.findByTelefone(usuario.getTelefone())
                .stream()
                .anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));

        if (telefoneEmUso) {
            throw new DomainException("Já existe um usuário cadastrado com esse telefone!");
        }

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void excluir(Long usuarioId){
        usuarioRepository.deleteById(usuarioId);
    }
}
