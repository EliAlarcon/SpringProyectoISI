package com.proyectofinal.SpringProyectoISI.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNota;

    @ManyToOne
    @JoinColumn(name = "idTarea")
    private Tarea tarea;

    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Usuario estudiante;

    private Double nota;
}