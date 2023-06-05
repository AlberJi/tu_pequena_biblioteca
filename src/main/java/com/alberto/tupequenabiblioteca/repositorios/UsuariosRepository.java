package com.alberto.tupequenabiblioteca.repositorios;

import com.alberto.tupequenabiblioteca.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findFirstByUsername(String nombre);

}

