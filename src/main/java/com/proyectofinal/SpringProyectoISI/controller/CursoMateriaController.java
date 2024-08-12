package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.CursoMateria;
import com.proyectofinal.SpringProyectoISI.CursoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursoMaterias")
public class CursoMateriaController {

    @Autowired
    private CursoMateriaService cursoMateriaService;

    @GetMapping
    public List<CursoMateria> getAllCursoMaterias() {
        return cursoMateriaService.getAllCursoMaterias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoMateria> getCursoMateriaById(@PathVariable int id) {
        Optional<CursoMateria> cursoMateria = cursoMateriaService.getCursoMateriaById(id);
        return cursoMateria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CursoMateria createCursoMateria(@RequestBody CursoMateria cursoMateria) {
        return cursoMateriaService.saveCursoMateria(cursoMateria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoMateria> updateCursoMateria(@PathVariable int id, @RequestBody CursoMateria cursoMateriaDetails) {
        CursoMateria updatedCursoMateria = cursoMateriaService.updateCursoMateria(id, cursoMateriaDetails);
        if (updatedCursoMateria != null) {
            return ResponseEntity.ok(updatedCursoMateria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCursoMateria(@PathVariable int id) {
        if (cursoMateriaService.getCursoMateriaById(id).isPresent()) {
            cursoMateriaService.deleteCursoMateria(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}