package com.proyectofinal.SpringProyectoISI.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;
}