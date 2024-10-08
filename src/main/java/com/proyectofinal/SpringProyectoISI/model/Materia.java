package com.proyectofinal.SpringProyectoISI.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "idProfesor")
    private Usuario profesor;
}