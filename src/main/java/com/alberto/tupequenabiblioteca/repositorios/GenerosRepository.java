package com.alberto.tupequenabiblioteca.repositorios;


import com.alberto.tupequenabiblioteca.entidades.Generos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenerosRepository extends JpaRepository<Generos, Long> {

    Generos findByNombre(String Generos);


}
