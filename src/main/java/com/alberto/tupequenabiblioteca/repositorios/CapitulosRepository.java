package com.alberto.tupequenabiblioteca.repositorios;

import com.alberto.tupequenabiblioteca.entidades.Capitulos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapitulosRepository  extends JpaRepository<Capitulos, Long> {

    List<Capitulos> findAllByNovelaId(long ID_Novela);

    Capitulos findByTitulo(String nombre);
    Page<Capitulos> findAllByNovelaId(long ID_Novela, Pageable pageable);

}
