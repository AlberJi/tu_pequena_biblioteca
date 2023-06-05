package com.alberto.tupequenabiblioteca.controladores;


import com.alberto.tupequenabiblioteca.entidades.Preferencias;
import com.alberto.tupequenabiblioteca.entidades.Usuarios;
import com.alberto.tupequenabiblioteca.servicios.PreferenciasService;
import com.alberto.tupequenabiblioteca.servicios.UsuariosService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@Data
@Slf4j
@RequestMapping("/prefs")
public class PreferenciasController {

  private final PreferenciasService preferenciasService;
  private final UsuariosService usuarioService;

  @GetMapping("/edit")
  public String editPreferenciasForm(Model model) {

    Preferencias preferencias = preferenciasService.findUsuarioPreferencias().orElse(null);
    model.addAttribute("preferenciasForm", preferencias);
    model.addAttribute("opcionesIdioma", Map.of("es_ES", "Español", "en_US", "Inglés"));
    return "preferencias/form";
  }

  @PostMapping("/edit/submit")
  public String editarPreferenciasSubmit(@ModelAttribute("preferenciasForm") Preferencias preferencias) {
    log.info("Preferencias {}", preferencias);
    Usuarios usuario = usuarioService.findById(preferencias.getId());
    preferencias.setUsuarios(usuario);
    preferenciasService.saveAuth(preferencias);
    return "redirect:/empleado/list?lang=" + preferencias.getIdioma();
  }

  @GetMapping(value = "/list", produces = "application/json")
  public ResponseEntity<Object> listaPreferencias() {
    Preferencias prefs = preferenciasService.findUsuarioPreferencias().orElse(null);
    return ResponseEntity.ok().body(Map.of(
      "darkMode", prefs.isDarkMode(),
      "idioma", prefs.getIdioma()));
  }


}
