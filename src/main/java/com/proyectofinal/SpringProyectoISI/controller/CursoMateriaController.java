package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.CursoMateria;
import com.proyectofinal.SpringProyectoISI.repository.CursoMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursoMaterias")
public class CursoMateriaController {

    @Autowired
    private CursoMateriaRepository cursoMateriaRepository;

    @GetMapping
    public List<CursoMateria> getAllCursoMaterias() {
        return cursoMateriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoMateria> getCursoMateriaById(@PathVariable int id) {
        Optional<CursoMateria> cursoMateria = cursoMateriaRepository.findById(id);
        return cursoMateria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CursoMateria createCursoMateria(@RequestBody CursoMateria cursoMateria) {
        return cursoMateriaRepository.save(cursoMateria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoMateria> updateCursoMateria(@PathVariable int id, @RequestBody CursoMateria cursoMateriaDetails) {
        Optional<CursoMateria> cursoMateria = cursoMateriaRepository.findById(id);

        if (cursoMateria.isPresent()) {
            CursoMateria updatedCursoMateria = cursoMateria.get();
            updatedCursoMateria.setCurso(cursoMateriaDetails.getCurso());
            updatedCursoMateria.setMateria(cursoMateriaDetails.getMateria());
            return ResponseEntity.ok(cursoMateriaRepository.save(updatedCursoMateria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCursoMateria(@PathVariable int id) {
        if (cursoMateriaRepository.existsById(id)) {
            cursoMateriaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}