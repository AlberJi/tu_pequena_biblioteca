package com.alberto.tu_pequena_biblioteca.entidades;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Constraint;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Usuarios {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private String email;

    private String role;
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    private Suscripciones suscripcion;
    @OneToMany(mappedBy = "usuario")
    private List<BibliotecaPersonal> bibliotecaPersonal;


}
