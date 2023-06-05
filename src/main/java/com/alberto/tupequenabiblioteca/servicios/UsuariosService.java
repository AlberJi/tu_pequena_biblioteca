package com.alberto.tupequenabiblioteca.servicios;

import com.alberto.tupequenabiblioteca.entidades.Usuarios;
import com.alberto.tupequenabiblioteca.repositorios.UsuariosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
