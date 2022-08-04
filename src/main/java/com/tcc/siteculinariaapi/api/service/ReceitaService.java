package com.tcc.siteculinariaapi.api.service;

import com.tcc.siteculinariaapi.api.exception.DomainException;
import com.tcc.siteculinariaapi.api.model.Receita;
import com.tcc.siteculinariaapi.api.model.Usuario;
import com.tcc.siteculinariaapi.api.repository.ReceitaRepository;
import com.tcc.siteculinariaapi.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ReceitaService {

    private UsuarioService usuarioService;
    private ReceitaRepository receitaRepository;

    @Transactional
    public Receita salvar(Receita receita){
        Usuario usuario = usuarioService.buscar(receita.getUsuario().getId());

        receita.setUsuario(usuario);

        boolean nomeEmUso = receitaRepository.findByNome(receita.getNome())
                .stream()
                .anyMatch(nomeExistente -> !nomeExistente.equals(receita));

        if (nomeEmUso) {
            throw new DomainException("Já existe uma receita com este nome");
        }

        return receitaRepository.save(receita);
    }
}
