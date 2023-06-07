package com.alberto.tupequenabiblioteca.controladores;

import com.alberto.tupequenabiblioteca.entidades.BibliotecaPersonal;
import com.alberto.tupequenabiblioteca.entidades.Novela;
import com.alberto.tupequenabiblioteca.entidades.Usuarios;
import com.alberto.tupequenabiblioteca.repositorios.BibliotecaPRepository;
import com.alberto.tupequenabiblioteca.servicios.BibliotecaPService;
import com.alberto.tupequenabiblioteca.servicios.NovelaService;
import com.alberto.tupequenabiblioteca.servicios.UsuariosService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Data
@Slf4j
@RequestMapping("/bibliotecaPersonal")
public class BibliotecaPController {

    @Autowired
    private final NovelaService novelaService;
    @Autowired
    private final UsuariosService usuariosService;
    @Autowired
    private final BibliotecaPService biblioteca_Personal;
    @Autowired
    private final BibliotecaPRepository repositorioBiP;


    @GetMapping("/{nombre}")
    public String bibliotecaP(@PathVariable String nombre, @RequestParam(value = "novelaId", required = false) Long novelaId, Principal principal, Model model) {
        Usuarios usuarios = usuariosService.findByNombre(nombre);
        BibliotecaPersonal bibliotecaPersonal = biblioteca_Personal.findByUsuarioId(usuarios.getId());

        if (bibliotecaPersonal == null) {
            bibliotecaPersonal = new BibliotecaPersonal();
            bibliotecaPersonal.setUsuario(usuarios);
            bibliotecaPersonal = biblioteca_Personal.save(bibliotecaPersonal);
        }

        if (novelaId != null) {
            biblioteca_Personal.agregarNovelaABiblioteca(usuarios.getId(), novelaId);
        }

        List<Novela> novelas = new ArrayList<>(bibliotecaPersonal.getNovelas());
        model.addAttribute("novelas", novelas);

        return "bibliotecaPersonal";
    }


}
