package com.alberto.tu_pequena_biblioteca.repositorios;

import com.alberto.tu_pequena_biblioteca.entidades.Capitulos;
import com.alberto.tu_pequena_biblioteca.entidades.Generos;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovelaRepository extends JpaRepository<Novela, Long> {
    List<Novela> findAllByOrderByIdDesc();
    List<Novela> findAllByGeneros(Generos generos);
    Novela findByTitulo(String nombre);
    List<Novela> findAllByOrderByPuntuacionAsc();

}
