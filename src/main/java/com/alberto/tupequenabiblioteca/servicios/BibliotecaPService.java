package com.alberto.tupequenabiblioteca.servicios;

import com.alberto.tupequenabiblioteca.entidades.BibliotecaPersonal;
import com.alberto.tupequenabiblioteca.entidades.Novela;
import com.alberto.tupequenabiblioteca.entidades.Usuarios;
import com.alberto.tupequenabiblioteca.repositorios.BibliotecaPRepository;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
