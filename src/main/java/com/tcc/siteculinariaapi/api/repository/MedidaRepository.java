package com.tcc.siteculinariaapi.api.repository;

import com.tcc.siteculinariaapi.api.model.Ingredientes;
import com.tcc.siteculinariaapi.api.model.Medidas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedidaRepository extends JpaRepository<Medidas, Long> {

    Optional<Ingredientes> findByNome(String nome);
}
