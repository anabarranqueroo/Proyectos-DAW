package com.proyectoCochesRest.repo;

import com.proyectoCochesRest.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByCocheIdOrderByIdAsc(Long cocheId);
}