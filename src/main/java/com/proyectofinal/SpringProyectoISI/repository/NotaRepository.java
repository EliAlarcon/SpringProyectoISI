package com.proyectofinal.SpringProyectoISI.repository;

import com.proyectofinal.SpringProyectoISI.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
}