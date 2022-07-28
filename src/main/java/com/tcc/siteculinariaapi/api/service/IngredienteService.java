package com.tcc.siteculinariaapi.api.service;


import com.tcc.siteculinariaapi.api.exception.DomainException;
import com.tcc.siteculinariaapi.api.model.Ingrediente;
import com.tcc.siteculinariaapi.api.repository.IngredienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class IngredienteService {

    private IngredienteRepository ingredienteRepository;

    public Ingrediente salvar(Ingrediente ingrediente){
        boolean ingredienteEmUso = ingredienteRepository.findByNome(ingrediente.getNome())
                .stream()
                .anyMatch(ingredienteExiste -> !ingredienteExiste.equals(ingrediente));

        if (ingredienteEmUso) {
            throw new DomainException("Já existe esse ingrediente!");
        }

        return ingredienteRepository.save(ingrediente);
    }

    public void excluir(Long ingredienteId){
        ingredienteRepository.deleteById(ingredienteId);
    }

}
