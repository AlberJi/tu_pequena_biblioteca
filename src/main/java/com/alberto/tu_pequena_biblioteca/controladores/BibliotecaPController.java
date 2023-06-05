package com.alberto.tu_pequena_biblioteca.controladores;

import com.alberto.tu_pequena_biblioteca.entidades.BibliotecaPersonal;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import com.alberto.tu_pequena_biblioteca.entidades.Usuarios;
import com.alberto.tu_pequena_biblioteca.repositorios.BibliotecaPRepository;
import com.alberto.tu_pequena_biblioteca.servicios.BibliotecaPService;
import com.alberto.tu_pequena_biblioteca.servicios.NovelaService;
import com.alberto.tu_pequena_biblioteca.servicios.UsuariosService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
//    @GetMapping("/{nombre}")
//    public String bibliotecaP(@PathVariable String nombre, Model model) {
//        Usuarios usuarios = usuariosService.findByNombre(nombre);
//        BibliotecaPersonal bibliotecaPersonal = biblioteca_Personal.findByUsuarioId(usuarios.getId());
//
//        if (bibliotecaPersonal == null) {
//            bibliotecaPersonal = new BibliotecaPersonal();
//            bibliotecaPersonal.setUsuario(usuarios);
//            bibliotecaPersonal = biblioteca_Personal.save(bibliotecaPersonal);
//        }
//        List<Novela> novelas = new ArrayList<>(bibliotecaPersonal.getNovelas());
//        model.addAttribute("novelas", novelas);
//
//
//        return "bibliotecaPersonal";
//    }
//    @GetMapping("/favoritos/new")
//    public String agregarNovelaABiblioteca(@RequestParam("novelaId") long novelaId, Principal principal, Model model) {
//        String nombreUsuario = principal.getName();
//        Usuarios usuario = usuariosService.findByNombre(nombreUsuario);
//        long usuarioId = usuario.getId();
//
//        System.out.println("ID del usuario: " + usuarioId);
//
//        biblioteca_Personal.agregarNovelaABiblioteca(usuarioId, novelaId);
//
//        model.addAttribute("redirectUrl", "/bibliotecaPersonal/" + nombreUsuario);
//
//        return "redirect:/redirect";
//    }

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
