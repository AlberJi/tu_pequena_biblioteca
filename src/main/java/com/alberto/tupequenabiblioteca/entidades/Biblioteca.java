package com.alberto.tupequenabiblioteca.entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Biblioteca {

    @Id
    @GeneratedValue
    private Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Novela novelas_glo;

}
