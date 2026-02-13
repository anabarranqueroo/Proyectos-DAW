package com.proyectoCochesRest.repo;

import com.proyectoCochesRest.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocheRepository extends JpaRepository<Coche, Long> {
}