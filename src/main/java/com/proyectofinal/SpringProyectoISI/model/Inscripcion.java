package com.proyectofinal.SpringProyectoISI.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInscripcion;
    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Usuario estudiante;
    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;
    private Date fechaInscripcion;
}