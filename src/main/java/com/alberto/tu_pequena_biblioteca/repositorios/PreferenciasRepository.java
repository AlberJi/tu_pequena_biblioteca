package com.alberto.tu_pequena_biblioteca.repositorios;


import com.alberto.tu_pequena_biblioteca.entidades.Preferencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.Optional;

public interface PreferenciasRepository extends JpaRepository<Preferencias, Long> {

  //@PreAuthorize("#entity.usuario.username == authentication.name")
  Preferencias save(Preferencias entity);

  @PostAuthorize("returnObject != null and returnObject.usuarios.username == authentication.name")
  Optional<Preferencias> findById(Long id);

  @Query("select p from #{#entityName} p where p.usuarios.username = ?#{authentication.name}")
  Optional<Preferencias> findUsuarioPreferencias();
}
