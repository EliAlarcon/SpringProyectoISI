package com.proyectofinal.SpringProyectoISI.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarea;

    @ManyToOne
    @JoinColumn(name = "idCursoMateria", nullable = false)
    private CursoMateria cursoMateria;

    private String titulo;
    private String descripcion;
    private String tipo;
    private float equivalente;

    @OneToMany(mappedBy = "tarea")
    private Set<Nota> notas;

    // Getters y setters

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public CursoMateria getCursoMateria() {
        return cursoMateria;
    }

    public void setCursoMateria(CursoMateria cursoMateria) {
        this.cursoMateria = cursoMateria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getEquivalente() {
        return equivalente;
    }

    public void setEquivalente(float equivalente) {
        this.equivalente = equivalente;
    }

    public Set<Nota> getNotas() {
        return notas;
    }

    public void setNotas(Set<Nota> notas) {
        this.notas = notas;
    }
}