package com.alberto.tu_pequena_biblioteca.servicios;

import com.alberto.tu_pequena_biblioteca.entidades.Generos;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import com.alberto.tu_pequena_biblioteca.entidades.Usuarios;
import com.alberto.tu_pequena_biblioteca.repositorios.UsuariosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UsuariosService {

    private final UsuariosRepository repositorio;
    private final PasswordEncoder passwordEncoder;

    public Usuarios findByNombre(String nombre) {
        return repositorio.findFirstByUsername(nombre);
    }

    public Usuarios save(Usuarios e) {
        e.setPassword(passwordEncoder.encode(e.getPassword()));
        return repositorio.save(e);
    }
    public Usuarios add(Usuarios e) {
        return repositorio.save(e);
    }
    public Usuarios findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Transactional
    public void deleteAll() {repositorio.deleteAllInBatch();}
}
