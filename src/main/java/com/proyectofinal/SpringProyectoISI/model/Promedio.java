package com.proyectofinal.SpringProyectoISI.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Promedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPromedio;

    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Usuario estudiante;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    private Double promedio;
}