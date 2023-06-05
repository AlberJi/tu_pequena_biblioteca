package com.alberto.tu_pequena_biblioteca.servicios;

import com.alberto.tu_pequena_biblioteca.entidades.Capitulos;
import com.alberto.tu_pequena_biblioteca.entidades.Generos;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import com.alberto.tu_pequena_biblioteca.repositorios.NovelaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class NovelaService {
    private final NovelaRepository repositorio;

    public List<Novela> findAll() {
        return repositorio.findAll();
    }

    public List<Novela> findAllByGeneros(Generos generos) {
        return repositorio.findAllByGeneros(generos);
    }
    public Novela findByName(String name) {
        return repositorio.findByTitulo(name);
    }
    public Novela findById(long id) {
        return repositorio.findById(id).orElse(null);
    }
    public List<Novela> findAllByOrderByIdDesc() {
        return repositorio.findAllByOrderByIdDesc();
    }


    public List<Novela> findByPuntuacion() {
        return repositorio.findAllByOrderByPuntuacionAsc();
    }
    public void saveAll(List<Novela> lista) {
        repositorio.saveAll(lista);
    }
    @Transactional
    public void deleteAll() {repositorio.deleteAllInBatch();}
}
