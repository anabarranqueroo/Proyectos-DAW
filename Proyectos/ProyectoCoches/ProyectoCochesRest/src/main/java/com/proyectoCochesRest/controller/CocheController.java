package com.proyectoCochesRest.controller;

import com.proyectoCochesRest.model.Coche;
import com.proyectoCochesRest.model.Modelo;
import com.proyectoCochesRest.service.CocheService;
import com.proyectoCochesRest.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CocheController {

    private final CocheService cocheService;
    private final ModeloService modeloService;

    public CocheController(CocheService cocheService, ModeloService modeloService) {
        this.cocheService = cocheService;
        this.modeloService = modeloService;
    }
    
    //COCHES

    @GetMapping("/coches")
    public List<Coche> listarCoches() {
        return cocheService.findAll();
    }

    @GetMapping("/coches/{id}")
    public Coche obtenerCoche(@PathVariable Long id) {
        return cocheService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/coches")
    public Coche crearCoche(@Valid @RequestBody Coche coche) {
        coche.setId(null);
        return cocheService.create(coche);
    }

    @PutMapping("/coches/{id}")
    public Coche editarCoche(@PathVariable Long id, @Valid @RequestBody Coche coche) {
        return cocheService.update(id, coche);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/coches/{id}")
    public void borrarCoche(@PathVariable Long id) {
        cocheService.delete(id);
    }

    //MODELOS

    @GetMapping("/coches/{cocheId}/modelos")
    public List<Modelo> listarModelos(@PathVariable Long cocheId) {
        return modeloService.listarDeCoche(cocheId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/coches/{cocheId}/modelos")
    public Modelo crearModelo(@PathVariable Long cocheId, @Valid @RequestBody Modelo modelo) {
        modelo.setId(null);
        return modeloService.crearEnCoche(cocheId, modelo);
    }

    @PutMapping("/coches/{cocheId}/modelos/{modeloId}")
    public Modelo editarModelo(@PathVariable Long cocheId,
                               @PathVariable Long modeloId,
                               @Valid @RequestBody Modelo modelo) {
        return modeloService.actualizar(cocheId, modeloId, modelo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/coches/{cocheId}/modelos/{modeloId}")
    public void borrarModelo(@PathVariable Long cocheId, @PathVariable Long modeloId) {
        modeloService.eliminar(cocheId, modeloId);
    }
    
    @GetMapping("/coches/{cocheId}/modelos/{modeloId}")
    public Modelo obtenerModelo(@PathVariable Long cocheId, @PathVariable Long modeloId) {
        // Asegúrate de que este método exista en tu modeloService
        // Si se llama distinto, cambia el nombre aquí
        return modeloService.findById(modeloId); 
    }
}