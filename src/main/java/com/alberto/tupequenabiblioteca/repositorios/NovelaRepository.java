package com.alberto.tupequenabiblioteca.repositorios;

import com.alberto.tupequenabiblioteca.entidades.Generos;
import com.alberto.tupequenabiblioteca.entidades.Novela;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovelaRepository extends JpaRepository<Novela, Long> {
    List<Novela> findAllByOrderByIdDesc();
    List<Novela> findAllByGeneros(Generos generos);
    Novela findByTitulo(String nombre);
    List<Novela> findAllByOrderByPuntuacionAsc();

}
