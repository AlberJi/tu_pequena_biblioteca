package com.alberto.tupequenabiblioteca.controladores;

import com.alberto.tupequenabiblioteca.entidades.Generos;
import com.alberto.tupequenabiblioteca.servicios.GenerosService;
import com.alberto.tupequenabiblioteca.servicios.NovelaService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Data
@Controller
public class BusquedaController {
    @Autowired
    private final NovelaService novelaService;
    @Autowired
    private final GenerosService generosService;


    @GetMapping("/busqueda")
    public String busquedaTotal(Model model) {
        model.addAttribute("novelas", novelaService.findAll());
        model.addAttribute("generos", generosService.findAll());
        return "busqueda";
    }

    @GetMapping("/busqueda/{genero}")
    public String novelaPorGeneros(@PathVariable String genero,  Model model) {
        Generos generobusqueda = generosService.findByNombre(genero);
        model.addAttribute("generos", generosService.findAll());
        model.addAttribute("novelasPorgenero", novelaService.findAllByGeneros(generobusqueda));
        return "busqueda";
    }
}
