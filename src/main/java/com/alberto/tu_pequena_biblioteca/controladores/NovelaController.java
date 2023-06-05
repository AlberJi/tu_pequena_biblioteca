package com.alberto.tu_pequena_biblioteca.controladores;

import com.alberto.tu_pequena_biblioteca.entidades.Capitulos;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import com.alberto.tu_pequena_biblioteca.servicios.CapitulosService;
import com.alberto.tu_pequena_biblioteca.servicios.NovelaService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String novelaCapitulo(@PathVariable String nombre, String nombre_novela, Model model) {
        Capitulos listaid = capitulosService.findByName(nombre);

        List<Capitulos> listado = capitulosService.findAllByNovelaId(listaid.getNovela().getId());
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

        return "capitulos";
    }

}
