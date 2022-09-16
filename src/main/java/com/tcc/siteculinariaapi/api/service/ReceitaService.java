package com.tcc.siteculinariaapi.api.service;

import com.tcc.siteculinariaapi.api.exception.DomainException;
import com.tcc.siteculinariaapi.api.model.Receitas;
import com.tcc.siteculinariaapi.api.repository.ReceitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ReceitaService {

    private ReceitaRepository receitaRepository;


    @Transactional
    public Receitas salvar(Receitas receitas){
        boolean receitaEmUso = receitaRepository.findByNome(receitas.getNome())
                .stream()
                .anyMatch(receitaExiste -> !receitaExiste.equals(receitas));

        if (receitaEmUso) {
            throw new DomainException("Já existe essa receita!");
        }

        return receitaRepository.save(receitas);
    }

    public void excluir(Long receitaId){
        receitaRepository.deleteById(receitaId);
    }

}
