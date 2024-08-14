package com.proyectofinal.SpringProyectoISI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.SpringProyectoISI.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera , Integer> {

}
