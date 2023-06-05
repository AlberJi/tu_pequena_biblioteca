package com.alberto.tu_pequena_biblioteca.repositorios;

import com.alberto.tu_pequena_biblioteca.entidades.BibliotecaPersonal;

import com.alberto.tu_pequena_biblioteca.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaPRepository extends JpaRepository<BibliotecaPersonal, Long> {
    BibliotecaPersonal findByUsuarioId(long id);
    BibliotecaPersonal findByUsuario(Usuarios usuario);


}
