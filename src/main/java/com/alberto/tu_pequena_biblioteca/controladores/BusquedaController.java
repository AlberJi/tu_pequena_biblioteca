package com.alberto.tu_pequena_biblioteca.controladores;

import com.alberto.tu_pequena_biblioteca.entidades.Capitulos;
import com.alberto.tu_pequena_biblioteca.entidades.Generos;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import com.alberto.tu_pequena_biblioteca.servicios.GenerosService;
import com.alberto.tu_pequena_biblioteca.servicios.NovelaService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
