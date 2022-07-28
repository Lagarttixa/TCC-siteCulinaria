package com.tcc.siteculinariaapi.api.repository;

import com.tcc.siteculinariaapi.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long > {

    Optional<Usuario> findByTelefone(String telefone);

}
