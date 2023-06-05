package com.alberto.tupequenabiblioteca.repositorios;

import com.alberto.tupequenabiblioteca.entidades.BibliotecaPersonal;

import com.alberto.tupequenabiblioteca.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaPRepository extends JpaRepository<BibliotecaPersonal, Long> {
    BibliotecaPersonal findByUsuarioId(long id);
    BibliotecaPersonal findByUsuario(Usuarios usuario);


}
