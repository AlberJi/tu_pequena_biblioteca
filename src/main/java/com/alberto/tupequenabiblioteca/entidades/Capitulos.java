package com.alberto.tupequenabiblioteca.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
    @Column(length = 20000)
    private String parrafo;
    private String parrafo2;
    private String parrafo3;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Novela novela;

    public void setParrafoFromFile(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            reader.close();
            this.parrafo = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
