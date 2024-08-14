package com.proyectofinal.SpringProyectoISI.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String nombre;

    private String apellido;

    private String email;

    private String contrasena;

    private String tipo;


}