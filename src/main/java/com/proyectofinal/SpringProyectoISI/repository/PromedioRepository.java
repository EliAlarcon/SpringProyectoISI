package com.proyectofinal.SpringProyectoISI.repository;

import com.proyectofinal.SpringProyectoISI.model.Promedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromedioRepository extends JpaRepository<Promedio, Integer> {
}
