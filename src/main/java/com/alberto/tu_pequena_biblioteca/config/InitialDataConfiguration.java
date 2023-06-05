package com.alberto.tu_pequena_biblioteca.config;





import com.alberto.tu_pequena_biblioteca.entidades.*;
import com.alberto.tu_pequena_biblioteca.servicios.*;
import com.alberto.tu_pequena_biblioteca.storage.StorageService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Slf4j
@Configuration
@EnableJpaAuditing
public class InitialDataConfiguration {


  @Autowired
  StorageService storageService;

  @Autowired
  private UsuariosService usuariosService;

  @Autowired
  private NovelaService novelaService;

  @Autowired
  private CapitulosService capitulosService;
  @Autowired
  private GenerosService generosService;
  @Autowired
  private BibliotecaPService bibliotecaPService;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private PreferenciasService preferenciasService;



  @PostConstruct
  public void initStorage() {
      storageService.deleteAll();
      storageService.init();

  }

  @PostConstruct
  public void initUsuarios() {
    bibliotecaPService.deleteAll();
    preferenciasService.deleteAll();
    usuariosService.deleteAll();

    Usuarios usuario1 = Usuarios.builder()
            .username("user").password(passwordEncoder.encode("user")).role("ROLE_USER").email("pepe@gmail.com").build();
    Preferencias prefs1 = Preferencias.builder().darkMode(true).idioma("en_US").usuarios(usuario1).build();
    preferenciasService.save(prefs1);

    Usuarios usuario2 = Usuarios.builder()
            .username("admin").password(passwordEncoder.encode("admin")).role("ROLE_ADMIN").email("maricarmen@gmail.com").build();
    Preferencias prefs2 = Preferencias.builder().darkMode(false).idioma("es_ES").usuarios(usuario2).build();
    preferenciasService.save(prefs2);
  }
  @PostConstruct
  public void initNovelas() {
    bibliotecaPService.deleteAll();
    capitulosService.deleteAll();
    novelaService.deleteAll();
    generosService.deleteAll();
    Generos gen1 = Generos.builder()
            .nombre("Fantasia")
            .build();
    Generos gen2 = Generos.builder()
            .nombre("Aventura")
            .build();
    Generos gen3 = Generos.builder()
            .nombre("Accion")
            .build();
    Generos gen4 = Generos.builder()
            .nombre("Romance")
            .build();

    Novela novela1 = Novela.builder()
            .titulo("Prueba1")
            .sinopsis("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .generos(gen1)
            .estado("En curso")
            .autor("Autor1")
            .imagen("../img/circulo.png")
            .puntuacion(6)
            .build();

    Novela novela2 = Novela.builder()
            .titulo("Prueba2")
            .sinopsis("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .generos(gen2)
            .estado("En curso")
            .autor("Autor2")
            .imagen("../img/plantilla.webp")
            .puntuacion(4)
            .build();

    Novela novela3 = Novela.builder()
            .titulo("Prueba3")
            .sinopsis("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .generos(gen3)
            .estado("En curso")
            .autor("Autor3")
            .imagen("../img/triangulo.png")
            .puntuacion(10)
            .build();

    Novela novela4 = Novela.builder()
            .titulo("Prueba4")
            .sinopsis("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .generos(gen4)
            .estado("En curso")
            .autor("Autor4")
            .imagen("../img/cuadrado.png")
            .puntuacion(9)
            .build();

    novelaService.saveAll(Arrays.asList(novela1, novela2, novela3,novela4));

    Capitulos capitulos1 = Capitulos.builder()
            .titulo("TituloPrueba1")
            .numero(1)
            .parrafo("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo2("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo3("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .novela(novela1)
            .build();
    Capitulos capitulos2 = Capitulos.builder()
            .titulo("TituloPrueba2")
            .numero(2)
            .parrafo("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo2("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo3("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .novela(novela1)
            .build();
    Capitulos capitulos3 = Capitulos.builder()
            .titulo("TituloPrueba3")
            .numero(3)
            .parrafo("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo2("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo3("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .novela(novela1)
            .build();
    Capitulos capitulos4 = Capitulos.builder()
            .titulo("TituloPrueba4")
            .numero(4)
            .parrafo("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo2("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo3("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .novela(novela1)
            .build();
    Capitulos capitulos1N2 = Capitulos.builder()
            .titulo("TituloPrueba5")
            .numero(1)
            .parrafo("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo2("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo3("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .novela(novela2)
            .build();
    Capitulos capitulos2N2 = Capitulos.builder()
            .titulo("TituloPrueba6")
            .numero(2)
            .parrafo("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo2("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo3("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .novela(novela2)
            .build();
    Capitulos capitulos3N2 = Capitulos.builder()
            .titulo("TituloPrueba7")
            .numero(3)
            .parrafo("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo2("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo3("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .novela(novela2)
            .build();
    Capitulos capitulos4N2 = Capitulos.builder()
            .titulo("TituloPrueba8")
            .numero(4)
            .parrafo("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo2("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .parrafo3("Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti nemo voluptate nesciunt?\n" +
                    "Necessitatibus, voluptatem aspernatur nisi cumque dolor fugiat minima voluptatum aperiam rerum\n" +
                    "aliquid dolorem,\n" +
                    "impedit numquam quasi excepturi explicabo!")
            .novela(novela2)
            .build();

    capitulosService.saveAll(Arrays.asList(capitulos1, capitulos2, capitulos3,capitulos4,capitulos1N2, capitulos2N2, capitulos3N2,capitulos4N2));

  }


}
