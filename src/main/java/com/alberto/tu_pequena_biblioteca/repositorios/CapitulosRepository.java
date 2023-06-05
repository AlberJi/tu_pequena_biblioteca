package com.alberto.tu_pequena_biblioteca.repositorios;

import com.alberto.tu_pequena_biblioteca.entidades.Capitulos;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapitulosRepository  extends JpaRepository<Capitulos, Long> {

    List<Capitulos> findAllByNovelaId(long ID_Novela);

    Capitulos findByTitulo(String nombre);
    Page<Capitulos> findAllByNovelaId(long ID_Novela, Pageable pageable);

}
