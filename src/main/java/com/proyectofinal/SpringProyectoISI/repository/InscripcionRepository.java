package com.proyectofinal.SpringProyectoISI.repository;

import com.proyectofinal.SpringProyectoISI.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {
}