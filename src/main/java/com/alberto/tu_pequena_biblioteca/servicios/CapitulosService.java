package com.alberto.tu_pequena_biblioteca.servicios;

import com.alberto.tu_pequena_biblioteca.entidades.Capitulos;
import com.alberto.tu_pequena_biblioteca.entidades.Novela;
import com.alberto.tu_pequena_biblioteca.repositorios.CapitulosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CapitulosService {
    private final CapitulosRepository repositorio;

    public List<Capitulos> findAll() {
        return repositorio.findAll();
    }
    public Page<Capitulos> getAll(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    public Page<Capitulos> findAllByNovelaId(long ID_Novela,Pageable pageable) {
        return repositorio.findAllByNovelaId(ID_Novela, pageable);

    }

    public void saveAll(List<Capitulos> capitulos) {
        repositorio.saveAll(capitulos);
    }
    public List<Capitulos> findAllByNovelaId(long ID_Novela){
        return  repositorio.findAllByNovelaId(ID_Novela);
    }
    public Capitulos findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Capitulos findByName(String name) {
        return repositorio.findByTitulo(name);
    }


    @Transactional
    public void deleteAll() {repositorio.deleteAllInBatch();}
}
