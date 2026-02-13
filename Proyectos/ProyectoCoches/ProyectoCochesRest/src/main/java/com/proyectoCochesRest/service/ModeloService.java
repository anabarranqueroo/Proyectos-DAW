package com.proyectoCochesRest.service;

import com.proyectoCochesRest.model.Coche;
import com.proyectoCochesRest.model.Modelo;
import com.proyectoCochesRest.repo.CocheRepository;
import com.proyectoCochesRest.repo.ModeloRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ModeloService {

    private final CocheRepository cocheRepository;
    private final ModeloRepository modeloRepository;

    public ModeloService(CocheRepository cocheRepository, ModeloRepository modeloRepository) {
        this.cocheRepository = cocheRepository;
        this.modeloRepository = modeloRepository;
    }

    private Coche getCocheOr404(Long cocheId) {
        return cocheRepository.findById(cocheId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coche no encontrado"));
    }

    public List<Modelo> listarDeCoche(Long cocheId) {
        return modeloRepository.findByCocheIdOrderByIdAsc(cocheId);
    }

    public Modelo crearEnCoche(Long cocheId, Modelo modelo) {
        Coche coche = getCocheOr404(cocheId);
        modelo.setId(null);
        modelo.setCoche(coche);
        return modeloRepository.save(modelo);
    }

    public Modelo obtener(Long cocheId, Long modeloId) {
        Modelo m = modeloRepository.findById(modeloId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo no encontrado"));
        if (m.getCoche() == null || !m.getCoche().getId().equals(cocheId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo no pertenece al coche");
        }
        return m;
    }

    public Modelo actualizar(Long cocheId, Long modeloId, Modelo cambios) {
        Modelo actual = obtener(cocheId, modeloId);
        actual.setNombre(cambios.getNombre());
        return modeloRepository.save(actual);
    }

    public void eliminar(Long cocheId, Long modeloId) {
        Modelo actual = obtener(cocheId, modeloId);
        modeloRepository.delete(actual);
    }
    
public Modelo findById(Long id) {
    return modeloRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo no encontrado"));
}
}