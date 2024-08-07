package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.Inscripcion;
import com.proyectofinal.SpringProyectoISI.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @GetMapping
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> getInscripcionById(@PathVariable int id) {
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);
        return inscripcion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inscripcion createInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> updateInscripcion(@PathVariable int id, @RequestBody Inscripcion inscripcionDetails) {
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);

        if (inscripcion.isPresent()) {
            Inscripcion updatedInscripcion = inscripcion.get();
            updatedInscripcion.setEstudiante(inscripcionDetails.getEstudiante());
            updatedInscripcion.setCurso(inscripcionDetails.getCurso());
            updatedInscripcion.setFechaInscripcion(inscripcionDetails.getFechaInscripcion());
            return ResponseEntity.ok(inscripcionRepository.save(updatedInscripcion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscripcion(@PathVariable int id) {
        if (inscripcionRepository.existsById(id)) {
            inscripcionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}