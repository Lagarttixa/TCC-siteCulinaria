package com.tcc.siteculinariaapi.api.repository;

import com.tcc.siteculinariaapi.api.model.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceitaRepository extends JpaRepository<Receitas, Long> {

    Optional<Receitas> findByNome(String nome);
}
