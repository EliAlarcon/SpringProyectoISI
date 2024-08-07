package com.proyectofinal.SpringProyectoISI.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idProfesor", nullable = false)
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private Set<CursoMateria> cursoMaterias;

    @OneToMany(mappedBy = "curso")
    private Set<Inscripcion> inscripciones;

    // Getters y setters

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<CursoMateria> getCursoMaterias() {
        return cursoMaterias;
    }

    public void setCursoMaterias(Set<CursoMateria> cursoMaterias) {
        this.cursoMaterias = cursoMaterias;
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}