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
public class Suscripciones {
    @Id
    private String tipo;
    private String derechos;

}
