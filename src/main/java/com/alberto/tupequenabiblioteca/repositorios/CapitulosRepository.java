package com.alberto.tupequenabiblioteca.repositorios;

import com.alberto.tupequenabiblioteca.entidades.Capitulos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CapitulosRepository  extends JpaRepository<Capitulos, Long> {

    List<Capitulos> findAllByNovelaId(long ID_Novela);

    Capitulos findByTitulo(String nombre);
    Page<Capitulos> findAllByNovelaId(long ID_Novela, Pageable pageable);

}
