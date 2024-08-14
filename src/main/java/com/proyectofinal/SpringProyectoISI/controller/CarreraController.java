package com.proyectofinal.SpringProyectoISI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyectofinal.SpringProyectoISI.model.Carrera;
import com.proyectofinal.SpringProyectoISI.services.CarreraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> getAllCarreras() {
        return carreraService.getAllCarreras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable int id) {
        Optional<Carrera> materia = carreraService.getCarreraById(id);
        return materia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        return carreraService.saveCarrera(carrera);
    }

    @PutMapping
    public ResponseEntity<Carrera> updateCarrera(@RequestBody Carrera carrera) {
        try {
            Carrera updateCarrera = carreraService.updateCarrera(carrera);
            return new ResponseEntity<>(updateCarrera, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable int id) {
        if (carreraService.getCarreraById(id).isPresent()) {
            carreraService.deleteCarrera(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}