package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.Materia;
import com.proyectofinal.SpringProyectoISI.services.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> getAllMaterias() {
        return materiaService.getAllMaterias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable int id) {
        Optional<Materia> materia = materiaService.getMateriaById(id);
        return materia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Materia createMateria(@RequestBody Materia materia) {
        return materiaService.saveMateria(materia);
    }

    @PutMapping
    public ResponseEntity<Materia> updateMateria(@RequestBody Materia materia) {
        try {
            Materia updateMateria = materiaService.updateMateria(materia);
            return new ResponseEntity<>(updateMateria, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable int id) {
        if (materiaService.getMateriaById(id).isPresent()) {
            materiaService.deleteMateria(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}