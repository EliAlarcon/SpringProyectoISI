package com.proyectofinal.SpringProyectoISI.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "curso_materia")
public class CursoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCursoMateria;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idMateria", nullable = false)
    private Materia materia;

    @OneToMany(mappedBy = "cursoMateria")
    private Set<Tarea> tareas;

    // Getters y setters

    public int getIdCursoMateria() {
        return idCursoMateria;
    }

    public void setIdCursoMateria(int idCursoMateria) {
        this.idCursoMateria = idCursoMateria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }
}