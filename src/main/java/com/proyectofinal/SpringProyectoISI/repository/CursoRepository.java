package com.proyectofinal.SpringProyectoISI.repository;

import com.proyectofinal.SpringProyectoISI.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}