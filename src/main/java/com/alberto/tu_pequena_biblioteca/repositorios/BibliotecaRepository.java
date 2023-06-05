package com.alberto.tu_pequena_biblioteca.repositorios;

import com.alberto.tu_pequena_biblioteca.entidades.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {


}
