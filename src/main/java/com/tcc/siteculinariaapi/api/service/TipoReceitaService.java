package com.tcc.siteculinariaapi.api.service;


import com.tcc.siteculinariaapi.api.exception.DomainException;
import com.tcc.siteculinariaapi.api.model.TipoReceita;
import com.tcc.siteculinariaapi.api.repository.TipoReceitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TipoReceitaService {

    private TipoReceitaRepository tipoReceitaRepository;

    @Transactional
    public TipoReceita salvar(TipoReceita tipoReceita){
        boolean tipoReceitaEmUso = tipoReceitaRepository.findByNome(tipoReceita.getNome())
                .stream()
                .anyMatch(tipoReceitaExiste -> !tipoReceitaExiste.equals(tipoReceita));

        if (tipoReceitaEmUso) {
            throw new DomainException("Já existe esse Tipo de Receita!");
        }

        return tipoReceitaRepository.save(tipoReceita);
    }

    public void excluir(Long tipoReceitaId){
        tipoReceitaRepository.deleteById(tipoReceitaId);
    }

}
