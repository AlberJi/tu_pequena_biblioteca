package com.alberto.tu_pequena_biblioteca.servicios;

import com.alberto.tu_pequena_biblioteca.entidades.BibliotecaPersonal;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import com.alberto.tu_pequena_biblioteca.entidades.Usuarios;
import com.alberto.tu_pequena_biblioteca.repositorios.BibliotecaPRepository;

import com.alberto.tu_pequena_biblioteca.repositorios.NovelaRepository;
import com.alberto.tu_pequena_biblioteca.repositorios.UsuariosRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class BibliotecaPService {

    private final BibliotecaPRepository repositorioBiP;
    private final UsuariosService usuariosService;
    private final NovelaService novelaService;
    @Autowired
    public BibliotecaPService(BibliotecaPRepository repositorioBiP, UsuariosService usuariosService, NovelaService novelaService) {
        this.repositorioBiP = repositorioBiP;
        this.usuariosService = usuariosService;
        this.novelaService = novelaService;
    }


    public BibliotecaPersonal findByUsuarioId(long id) {
        return repositorioBiP.findByUsuarioId(id);
    }

    public BibliotecaPersonal save(BibliotecaPersonal e) {
        return repositorioBiP.save(e);
    }

    public BibliotecaPersonal agregarNovelaABiblioteca(long usuarioId, long novelaId) {
        Usuarios usuario = usuariosService.findById(usuarioId);
        Novela novela = novelaService.findById(novelaId);

        if (usuario != null && novela != null) {
            BibliotecaPersonal bibliotecaPersonal = repositorioBiP.findByUsuario(usuario);

            if (bibliotecaPersonal == null) {
                bibliotecaPersonal = new BibliotecaPersonal();
                bibliotecaPersonal.setUsuario(usuario);
            }

            // Verificar si la novela ya está presente en la lista
            boolean novelaRepetida = false;
            for (Novela n : bibliotecaPersonal.getNovelas()) {
                if (n.getId().equals(novela.getId())) {
                    novelaRepetida = true;
                    break;
                }
            }

            if (!novelaRepetida) {
                bibliotecaPersonal.getNovelas().add(novela);
                return repositorioBiP.save(bibliotecaPersonal);
            }
        }

        return null; // Manejar el caso de usuario o novela nula o repetida según tus necesidades
    }
    @Transactional
    public void deleteAll() {repositorioBiP.deleteAllInBatch();}

}
