package com.proyectofinal.SpringProyectoISI.repository;

import com.proyectofinal.SpringProyectoISI.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}