package com.alberto.tu_pequena_biblioteca.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

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
