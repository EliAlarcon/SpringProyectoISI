package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.Nota;
import com.proyectofinal.SpringProyectoISI.services.NotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaService.getAllNotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable int id) {
        Optional<Nota> nota = notaService.getNotaById(id);
        return nota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaService.saveNota(nota);
    }

    @PutMapping
    public ResponseEntity<Nota> updateNota(@RequestBody Nota nota) {
        try {
            Nota updateNota = notaService.updateNota(nota);
            return new ResponseEntity<>(updateNota, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable int id) {
        if (notaService.getNotaById(id).isPresent()) {
            notaService.deleteNota(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}