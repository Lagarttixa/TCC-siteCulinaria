package com.tcc.siteculinariaapi.api.service;


import com.tcc.siteculinariaapi.api.exception.DomainException;
import com.tcc.siteculinariaapi.api.model.Ingredientes;
import com.tcc.siteculinariaapi.api.repository.IngredienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class IngredienteService {

    private IngredienteRepository ingredienteRepository;

    @Transactional
    public Ingredientes salvar(Ingredientes ingredientes){
        boolean ingredienteEmUso = ingredienteRepository.findByNome(ingredientes.getNome())
                .stream()
                .anyMatch(ingredientesExiste -> !ingredientesExiste.equals(ingredientes));

        if (ingredienteEmUso) {
            throw new DomainException("Já existe esse ingrediente!");
        }

        return ingredienteRepository.save(ingredientes);
    }

    public void excluir(Long ingredienteId){
        ingredienteRepository.deleteById(ingredienteId);
    }

}
