package com.tcc.siteculinariaapi.api.repository;

import com.tcc.siteculinariaapi.api.model.Receitas;
import com.tcc.siteculinariaapi.api.model.TipoReceita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoReceitaRepository extends JpaRepository<TipoReceita, Long> {

    Optional<Receitas> findByNome(String nome);

}
