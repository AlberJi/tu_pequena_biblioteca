package com.alberto.tupequenabiblioteca.controladores;

import com.alberto.tupequenabiblioteca.entidades.Capitulos;
import com.alberto.tupequenabiblioteca.entidades.Novela;
import com.alberto.tupequenabiblioteca.servicios.CapitulosService;
import com.alberto.tupequenabiblioteca.servicios.NovelaService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Slf4j
@Data
@Controller
@RequestMapping("/novela")
public class NovelaController {

    private final CapitulosService capitulosService;
    private final NovelaService novelasService;

    @GetMapping("/{nombre_novela}")
    public String novela(@PathVariable String nombre_novela, Model model) {
        Novela novela = novelasService.findByName(nombre_novela);
        long novela_id = novela.getId();
        List<Capitulos> capitulos = capitulosService.findAllByNovelaId(novela_id);

        model.addAttribute("novelaVista", novela);
        model.addAttribute("novelaCapitulos", capitulos);
        return "novela";
    }

    @GetMapping("/{nombre_novela}/{nombre}")
    public String novelaCapitulo(@PathVariable String nombre,@PathVariable String nombre_novela, Model model) {
        Capitulos listaid = capitulosService.findByName(nombre);
        long id = listaid.getNovela().getId();
        List<Capitulos> listado = capitulosService.findAllByNovelaId(id);
        int indiceActual = -1;
        int previo = -1;
        int siguiente = -1;

        for (Capitulos c : listado) {
            if (c.getTitulo().equals(nombre)) {
                indiceActual = listado.indexOf(c);
                previo = indiceActual - 1;
                siguiente = indiceActual + 1;
                break;
            }
        }

        if (indiceActual >= 0) {
            Capitulos capituloprev = (previo >= 0) ? listado.get(previo) : listado.get(listado.size() - 1);
            Capitulos capitulosig = (siguiente < listado.size()) ? listado.get(siguiente) : listado.get(0);
            model.addAttribute("prev", capituloprev);
            model.addAttribute("next", capitulosig);
            model.addAttribute("current", listado.get(indiceActual));
        }

        model.addAttribute("first", listado.get(0));
        model.addAttribute("last", listado.get(listado.size() - 1));
        model.addAttribute("capituloVista", listaid);
        model.addAttribute("novela_nombre", nombre_novela);

        return "capitulos";
    }


}
