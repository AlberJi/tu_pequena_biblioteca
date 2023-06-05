package com.alberto.tupequenabiblioteca.repositorios;

import com.alberto.tupequenabiblioteca.entidades.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {


}
