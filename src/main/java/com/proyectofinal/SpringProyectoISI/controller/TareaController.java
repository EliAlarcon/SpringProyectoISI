package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.Tarea;
import com.proyectofinal.SpringProyectoISI.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable int id) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        return tarea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable int id, @RequestBody Tarea tareaDetails) {
        Optional<Tarea> tarea = tareaRepository.findById(id);

        if (tarea.isPresent()) {
            Tarea updatedTarea = tarea.get();
            updatedTarea.setCursoMateria(tareaDetails.getCursoMateria());
            updatedTarea.setTitulo(tareaDetails.getTitulo());
            updatedTarea.setDescripcion(tareaDetails.getDescripcion());
            updatedTarea.setTipo(tareaDetails.getTipo());
            updatedTarea.setEquivalente(tareaDetails.getEquivalente());
            return ResponseEntity.ok(tareaRepository.save(updatedTarea));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable int id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}