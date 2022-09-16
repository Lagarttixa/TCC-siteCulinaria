package com.tcc.siteculinariaapi.api.service;


import com.tcc.siteculinariaapi.api.exception.DomainException;
import com.tcc.siteculinariaapi.api.model.Medidas;
import com.tcc.siteculinariaapi.api.repository.MedidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class MedidaService {

    private MedidaRepository medidaRepository;

    @Transactional
    public Medidas salvar(Medidas medidas){
        boolean medidaEmUso = medidaRepository.findByNome(medidas.getNome())
                .stream()
                .anyMatch(medidaExiste -> !medidaExiste.equals(medidas));

        if (medidaEmUso) {
            throw new DomainException("Já existe essa Medida!");
        }

        return medidaRepository.save(medidas);
    }

    public void excluir(Long ingredienteId){
        medidaRepository.deleteById(ingredienteId);
    }

}
