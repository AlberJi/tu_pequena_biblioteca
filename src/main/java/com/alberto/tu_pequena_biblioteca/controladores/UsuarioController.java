package com.alberto.tu_pequena_biblioteca.controladores;

import com.alberto.tu_pequena_biblioteca.dto.JpaMapper;
import com.alberto.tu_pequena_biblioteca.dto.SignupRequest;
import com.alberto.tu_pequena_biblioteca.entidades.Usuarios;
import com.alberto.tu_pequena_biblioteca.servicios.UsuariosService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Data
@Slf4j
@RequestMapping("/user")
public class UsuarioController {

    private final UsuariosService usuariosService;

    private final JpaMapper mapper;

    @GetMapping("/new")
    public String nuevoUsuarioForm(Model model) {
        model.addAttribute("usuarioForm", new Usuarios());
        return "usuarios/registro";
    }
    @PostMapping("/new/signup")
    public String register(@ModelAttribute SignupRequest signupRequest, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "usuarios/registro";
        }else {

            Usuarios usuarios = usuariosService.save(mapper.toEntity(signupRequest));
            usuarios.setRole("ROLE_USER");
            usuariosService.add(usuarios);
        }
        return "redirect:/login";
    }
}
