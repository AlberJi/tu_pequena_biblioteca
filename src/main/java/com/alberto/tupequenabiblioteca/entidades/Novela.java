package com.alberto.tupequenabiblioteca.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity

public class Novela {
    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    private String sinopsis;
    @OneToMany(mappedBy = "novela", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Capitulos> listado;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Generos generos;
    private String estado;
    private String autor;
    private String imagen;
    private int puntuacion;
    @OneToMany(mappedBy = "novelas_glo", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Biblioteca> biblioteca;
    @ManyToMany(mappedBy = "novelas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<BibliotecaPersonal> bibliotecaPersonal = new ArrayList<>();

}
