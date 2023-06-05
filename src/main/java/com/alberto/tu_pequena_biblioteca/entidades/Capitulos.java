package com.alberto.tu_pequena_biblioteca.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Capitulos {

    @Id
    @GeneratedValue
    private Long id;
    private int numero;
    private String titulo;
    private String parrafo;
    private String parrafo2;
    private String parrafo3;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Novela novela;
}
