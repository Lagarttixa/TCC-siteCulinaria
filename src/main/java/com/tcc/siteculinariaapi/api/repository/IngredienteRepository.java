package com.tcc.siteculinariaapi.api.repository;

import com.tcc.siteculinariaapi.api.model.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredienteRepository extends JpaRepository<Ingredientes, Long> {

    Optional<Ingredientes> findByNome(String nome);
}
