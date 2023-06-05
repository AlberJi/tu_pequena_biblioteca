package com.alberto.tu_pequena_biblioteca.repositorios;

import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import com.alberto.tu_pequena_biblioteca.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findFirstByUsername(String nombre);

}

