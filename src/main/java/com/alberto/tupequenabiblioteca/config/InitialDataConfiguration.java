package com.alberto.tupequenabiblioteca.config;





import com.alberto.tupequenabiblioteca.entidades.*;
import com.alberto.tupequenabiblioteca.servicios.*;
import com.alberto.tupequenabiblioteca.storage.StorageService;
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
            .titulo("Dungeon-Battle-Royale")
            .sinopsis("Un día, todos los humanos reciben un correo que promulga el Proyecto de Salvación Mundial. Kurosaki Shion, un diligente estudiante universitario, se convierte en un Rey Demonio y gobierna su propio Dominio en el nuevo mundo.")
            .generos(gen1)
            .estado("En curso")
            .autor("Gachasora")
            .imagen("../img/novela1.jpg")
            .puntuacion(6)
            .build();

    Novela novela2 = Novela.builder()
            .titulo("¿Por-qué-debería-dejar-de-ser-un-villano?")
            .sinopsis("En medio de un bosque en ruinas, yacía el cuerpo de un hombre con una lanza atravesándole el corazón. Aunque en sus momentos finales se mostró tranquilo y sereno. Lo único en su mente era: \"Perdóname, no pude cumplir mi promesa.\"")
            .generos(gen2)
            .estado("En curso")
            .autor("Raos_IOI")
            .imagen("../img/novela2.jpg")
            .puntuacion(4)
            .build();

    Novela novela3 = Novela.builder()
            .titulo("Sistema-de-intercambio-de-sinvergüenza transmigrado")
            .sinopsis("Han Cai tuvo una muy buena vida, " +
                    "ya que nació en una rica familia de comerciantes. " +
                    "Su familia era una de las más ricas del pueblo, y nadie se atrevía a ofenderlos.")
            .generos(gen3)
            .estado("En curso")
            .autor("Daoist_Drumstick")
            .imagen("../img/novela3.jpg")
            .puntuacion(10)
            .build();

    Novela novela4 = Novela.builder()
            .titulo("Libertinaje-de-Village Head")
            .sinopsis("Orion transmigra a un mundo primitivo donde el sexo y bienes se intercambian. Con determinación y encanto, navega el peligroso mundo de tentaciones y magia, aprovechando su segunda oportunidad.")
            .generos(gen4)
            .estado("En curso")
            .autor("Royalpanda")
            .imagen("../img/novela4.jpg")
            .puntuacion(9)
            .build();

    Novela novela5 = Novela.builder()
            .titulo("La-leyenda-más-fuerte-de-Dragon Ball")
            .sinopsis("Xiaya reencarnó en el Universo Dragon Ball como Saiyajin 12 años antes de la destrucción del Planeta Vegeta.")
            .generos(gen1)
            .estado("En curso")
            .autor("Conexión de la hoja de arce")
            .imagen("../img/novela5.jpg")
            .puntuacion(6)
            .build();

    Novela novela6 = Novela.builder()
            .titulo("Jugador-del-inframundo")
            .sinopsis("Descubrí que este mundo es peligroso. Bai Zhi, grave, escribía en su computadora. “Hoy vi a un hombre siendo mordido. He visto suficientes películas para saber qué pasó. El zombi fue eliminado antes de que el virus se propagara”.")
            .generos(gen2)
            .estado("En curso")
            .autor("Tiempo Nueve Vidas")
            .imagen("../img/novela6.jpg")
            .puntuacion(3)
            .build();

    Novela novela7 = Novela.builder()
            .titulo("Cultivador-marcial")
            .sinopsis("Chen Chao soñaba con ser un cultivador inmortal, pero descubrió su falta de talento. Se unió a otros artistas marciales sin talento y se embarcó en el camino del cultivo marcial.")
            .generos(gen3)
            .estado("En curso")
            .autor("Desconocido Frío")
            .imagen("../img/novela7.jpg")
            .puntuacion(1)
            .build();

    Novela novela8 = Novela.builder()
            .titulo("El-inadaptado-de-Demon-King-Academy")
            .sinopsis("Después de 2000 años, el despiadado señor de los demonios renace, pero es considerado inepto en una academia para señores demonios. Aunque puede destruir a humanos, elementales y dioses, busca un mundo pacífico y decide reencarnarse en el futuro.")
            .generos(gen4)
            .estado("En curso")
            .autor("Shuu")
            .imagen("../img/novela8.jpg")
            .puntuacion(8)
            .build();

    novelaService.saveAll(Arrays.asList(novela1, novela2, novela3, novela4, novela5, novela6, novela7, novela8));

    Capitulos capitulos1 = Capitulos.builder()
            .titulo("Capitulo 1")
            .numero(1)
            .parrafo("Año 20XX, el mundo se dirige a la ruina. La disminución de la población y el envejecimiento excesivo son evidentes. Muchos rechazan el éxito y el planeta se deteriora. Advertencias ignoradas. Es el fin del mundo, pero nadie siente peligro.")
            .parrafo2("Y, sin embargo, nadie siente peligro. Soy Kurosaki Shion, estudiante universitario. Elegí la universidad por su capacidad académica. Quería vivir solo. Es una escuela extraña, sin uniformes. La secundaria y la universidad son diferentes.")
            .parrafo3("Puede que muchos estudiantes estén contentos sin uniformes, pero para mí es un infierno. Además, crear mi propio horario y elegir las clases es complicado. ¿Quién quiere tomar microeconomía o macroeconomía? No hay clases hasta el segundo año.")
            .novela(novela1)
            .build();

    Capitulos capitulos2 = Capitulos.builder()
            .titulo("Capitulo 2")
            .numero(2)
            .parrafo("Al encender el televisor, todos los canales transmiten lo mismo: una prueba de aptitud obligatoria. Me pregunto qué está pasando. ¿Es un espectáculo sorpresa? También recibí un correo en la universidad. No puedo creer que movilicen a tanta gente por mí.")
            .parrafo2("No puedo creer que los sitios de noticias. Abro el correo: el 'Proyecto de Salvación Mundial'. Reúno coraje y hago clic en 'Iniciar'. Debo responder preguntas. Las aplicaciones en los teléfonos inteligentes pueden funcionar como detectores de mentiras.")
            .parrafo3("P1: ¿Hay alguien a quien quieras proteger en este mundo? 1. Más de 10. 2. Más de 5. 3. Más de 3. 4. Más de 1. 5. Nadie. Aunque tengo familia, me resisto a elegir. Luego, me preguntan si estoy satisfecho con mi vida actual.")
            .novela(novela1)
            .build();
    Capitulos capitulos3 = Capitulos.builder()
            .titulo("Capitulo 3")
            .numero(3)
            .parrafo("En un lugar desconocido, una voz emocionada me anuncia que espere 10 horas. Durante ese tiempo, escucho su voz cada hora, hasta que finalmente me prometen liberarme en una hora más, poniendo fin a mi extraña experiencia en esta 'prisión del alma'.")
            .parrafo2("La niña emocionada habla de crear un nuevo mundo con la ayuda de aquellos que aman la libertad y el caos. Su voz se vuelve desagradable, mientras explica que es natural que las cosas salgan así con personas de 【Chaos】 que aman la libertad y el caos.")
            .parrafo3("La chica explica que el fenómeno es el \"Proyecto de Salvación Mundial\" debido al colapso del mundo en 20 años. Critica a la humanidad por ser inútil y menciona problemas como la baja tasa de natalidad, la contaminación y la falta de motivación.")
            .novela(novela1)
            .build();
    Capitulos capitulos4 = Capitulos.builder()
            .titulo("Capitulo 4")
            .numero(4)
            .parrafo("El protagonista, confundido en su habitación, reflexiona sobre su extraña experiencia: confinamiento en un espacio extraño. Su teléfono causa dolor de cabeza y olvida su apellido y los nombres de sus padres. Las palabras del \"Mastermind\" le atormentan.")
            .parrafo2("Siente aislamiento en su habitación, sale y encuentra un mundo vacío. Regresa, ve nuevos íconos en su teléfono y toca uno en particular.")
            .parrafo3("El protagonista se sorprende al tocar el ícono en su teléfono inteligente y grita involuntariamente. En la pantalla aparece una explicación sobre la creación que afecta la creación del dominio y la creación del subordinado.")
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
    
    Capitulos capitulos9 = Capitulos.builder()
            .titulo("CapituloN31")
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
            .novela(novela3)
            .build();

    Capitulos capitulos10 = Capitulos.builder()
            .titulo("CapituloN32")
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
            .novela(novela3)
            .build();

    Capitulos capitulos11 = Capitulos.builder()
            .titulo("CapituloN41")
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
            .novela(novela4)
            .build();

    Capitulos capitulos12 = Capitulos.builder()
            .titulo("CapituloN42")
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
            .novela(novela4)
            .build();

    Capitulos capitulos13 = Capitulos.builder()
            .titulo("CapituloN51")
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
            .novela(novela5)
            .build();
    Capitulos capitulos14 = Capitulos.builder()
            .titulo("CapituloN52")
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
            .novela(novela5)
            .build();
    Capitulos capitulos15 = Capitulos.builder()
            .titulo("CapituloN61")
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
            .novela(novela6)
            .build();
    Capitulos capitulos16 = Capitulos.builder()
            .titulo("CapituloN62")
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
            .novela(novela6)
            .build();
    Capitulos capitulos17 = Capitulos.builder()
            .titulo("CapituloN71")
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
            .novela(novela7)
            .build();
    Capitulos capitulos18 = Capitulos.builder()
            .titulo("CapituloN72")
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
            .novela(novela7)
            .build();

    Capitulos capitulos19 = Capitulos.builder()
            .titulo("CapituloN81")
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
            .novela(novela8)
            .build();

    Capitulos capitulos20 = Capitulos.builder()
            .titulo("CapituloN82")
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
            .novela(novela8)
            .build();



    capitulosService.saveAll(Arrays.asList(capitulos1, capitulos2, capitulos3,capitulos4,capitulos1N2, capitulos2N2, capitulos3N2,capitulos4N2, capitulos9, capitulos10, capitulos11, capitulos12, capitulos13, capitulos14));
    capitulosService.saveAll((Arrays.asList(capitulos15, capitulos16, capitulos17, capitulos18, capitulos19, capitulos20)));
  }


}
