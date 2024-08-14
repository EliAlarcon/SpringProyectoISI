package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.Promedio;
import com.proyectofinal.SpringProyectoISI.services.PromedioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promedios")
public class PromedioController {

    @Autowired
    private PromedioService promedioService;

    @GetMapping
    public List<Promedio> getAllPromedios() {
        return promedioService.getAllPromedios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promedio> getPromedioById(@PathVariable int id) {
        Optional<Promedio> cursoMateria = promedioService.getPromedioById(id);
        return cursoMateria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Promedio createPromedio(@RequestBody Promedio promedio) {
        return promedioService.savePromedio(promedio);
    }

    @PutMapping
    public ResponseEntity<Promedio> updatePromedio(@RequestBody Promedio promedio) {
        try {
            Promedio updatePromedio = promedioService.updatePromedio(promedio);
            return new ResponseEntity<>(updatePromedio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromedio(@PathVariable int id) {
        if (promedioService.getPromedioById(id).isPresent()) {
            promedioService.deletePromedio(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}