package com.alberto.tu_pequena_biblioteca.repositorios;


import com.alberto.tu_pequena_biblioteca.entidades.Generos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenerosRepository extends JpaRepository<Generos, Long> {

    Generos findByNombre(String Generos);


}
