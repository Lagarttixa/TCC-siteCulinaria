package com.tcc.siteculinariaapi.api.repository;

import com.tcc.siteculinariaapi.api.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    Optional<Ingrediente> findByNome(String nome);
}
