package com.alberto.tupequenabiblioteca.servicios;


import com.alberto.tupequenabiblioteca.entidades.Generos;
import com.alberto.tupequenabiblioteca.entidades.Novela;
import com.alberto.tupequenabiblioteca.repositorios.GenerosRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class GenerosService {

        private final GenerosRepository repositorio;

        public List<Generos> findAll() {
            return repositorio.findAll();
        }


        public Generos findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
     }

        public void saveAll(List<Generos> lista) {
            repositorio.saveAll(lista);
        }

    public Generos save(Generos d) {
        List<Novela> videojuegos = d.getNovela();
        if (!videojuegos.isEmpty()) {
            videojuegos.forEach(empleado -> empleado.setGeneros(d));
        }
        return repositorio.save(d);
    }

        @Transactional
        public void deleteAll() {repositorio.deleteAllInBatch();}

        public void deleteById(Long id) {
            repositorio.deleteById(id);
        }

}
