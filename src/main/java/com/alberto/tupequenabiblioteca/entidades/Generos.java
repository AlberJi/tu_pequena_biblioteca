package com.alberto.tupequenabiblioteca.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Generos {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    @JsonIgnore
    @OneToMany(mappedBy = "generos", fetch = FetchType.EAGER)
    private List<Novela> novela;

    public void addNovela (Novela e) {
        novela.add(e);
        e.setGeneros(this);
    }

    public void removeNovela (Novela e) {
        novela.remove(e);
        e.setGeneros(null);
    }

}

