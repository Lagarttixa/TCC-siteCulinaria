package com.tcc.siteculinariaapi.api.repository;

import com.tcc.siteculinariaapi.api.model.Receita;
import com.tcc.siteculinariaapi.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    Optional<Receita> findByNome(String nome);
}
