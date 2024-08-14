package com.proyectofinal.SpringProyectoISI.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarea;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idMateria")
    private Materia materia;
    
}