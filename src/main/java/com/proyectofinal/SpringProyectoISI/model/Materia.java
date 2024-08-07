package com.proyectofinal.SpringProyectoISI.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "materia")
    private Set<CursoMateria> cursoMaterias;

    // Getters y setters

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
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

    public Set<CursoMateria> getCursoMaterias() {
        return cursoMaterias;
    }

    public void setCursoMaterias(Set<CursoMateria> cursoMaterias) {
        this.cursoMaterias = cursoMaterias;
    }
}