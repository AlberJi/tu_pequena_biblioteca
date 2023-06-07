package com.alberto.tupequenabiblioteca.controladores;


import com.alberto.tupequenabiblioteca.entidades.Novela;
import com.alberto.tupequenabiblioteca.servicios.I18nService;
import com.alberto.tupequenabiblioteca.servicios.NovelaService;
import com.alberto.tupequenabiblioteca.storage.StorageService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;
import java.io.IOException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Data
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private final StorageService storageService;

    @Autowired
    private final NovelaService novelaService;
    @Autowired
    private final I18nService servicioInternacionalizacion;

    @GetMapping({"", "index"})
    public String welcome(Model model) {
        model.addAttribute("listaNovelasNuevas", novelaService.findAllByOrderByIdDesc().subList(0,5));
        model.addAttribute("listaNovelasPun", novelaService.findByPuntuacion());
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String mostrarNovela(@PathVariable long id, Model model) {
        Novela novela = novelaService.findById(id);
        if (novela != null)
            model.addAttribute("novelaVista", novela);
            return "novela";

    }
    @GetMapping("/login")
    public String login(){
        return "usuarios/login";
    }


    @GetMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundError(HttpServletResponse response) throws IOException {
        response.sendRedirect("/forbidden");
        return "forbidden";
    }
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().body(file);
    }


}
