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
public class Preferencias {
  @Id
  private Long id;

  private boolean darkMode;
  private String idioma;

  @OneToOne(cascade = CascadeType.MERGE)
  @MapsId
  private Usuarios usuarios;
}
