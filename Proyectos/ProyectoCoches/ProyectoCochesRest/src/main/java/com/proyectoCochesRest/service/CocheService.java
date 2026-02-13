package com.proyectoCochesRest.service;

import com.proyectoCochesRest.model.Coche;
import com.proyectoCochesRest.repo.CocheRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CocheService {

    private final CocheRepository cocheRepository;

    public CocheService(CocheRepository cocheRepository) {
        this.cocheRepository = cocheRepository;
    }

    public List<Coche> findAll() {
        return cocheRepository.findAll();
    }

    public Coche findById(Long id) {
        return cocheRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coche no encontrado"));
    }

    public Coche create(Coche c) {
        c.setId(null);
        return cocheRepository.save(c);
    }

    public Coche update(Long id, Coche c) {
        Coche existing = findById(id);
        existing.setMarca(c.getMarca());
        existing.setAnoFabricacion(c.getAnoFabricacion());
        existing.setColor(c.getColor());
        existing.setPrecio(c.getPrecio());
        //existing.setModelos(c.getModelos()); 
        return cocheRepository.save(existing);
    }

    public void delete(Long id) {
        if (!cocheRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coche no encontrado");
        }
        cocheRepository.deleteById(id);
    }
}