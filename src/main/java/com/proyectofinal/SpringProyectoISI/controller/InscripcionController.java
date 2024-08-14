package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.Inscripcion;
import com.proyectofinal.SpringProyectoISI.services.InscripcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionService.getAllInscripciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> getInscripcionById(@PathVariable int id) {
        Optional<Inscripcion> inscripcion = inscripcionService.getInscripcionById(id);
        return inscripcion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inscripcion createInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.saveInscripcion(inscripcion);
    }

    @PutMapping
    public ResponseEntity<Inscripcion> updateInscripcion(@RequestBody Inscripcion inscripcionDetails) {
        Inscripcion updatedInscripcion = inscripcionService.updateInscripcion(inscripcionDetails);
        if (updatedInscripcion != null) {
            return ResponseEntity.ok(updatedInscripcion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscripcion(@PathVariable int id) {
        if (inscripcionService.getInscripcionById(id).isPresent()) {
            inscripcionService.deleteInscripcion(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}