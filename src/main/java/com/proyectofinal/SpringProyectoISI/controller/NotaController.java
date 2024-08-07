package com.proyectofinal.SpringProyectoISI.controller;

import com.proyectofinal.SpringProyectoISI.model.Nota;
import com.proyectofinal.SpringProyectoISI.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable int id) {
        Optional<Nota> nota = notaRepository.findById(id);
        return nota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable int id, @RequestBody Nota notaDetails) {
        Optional<Nota> nota = notaRepository.findById(id);

        if (nota.isPresent()) {
            Nota updatedNota = nota.get();
            updatedNota.setInscripcion(notaDetails.getInscripcion());
            updatedNota.setTarea(notaDetails.getTarea());
            updatedNota.setCalificacion(notaDetails.getCalificacion());
            updatedNota.setTipoEvaluacion(notaDetails.getTipoEvaluacion());
            updatedNota.setFecha(notaDetails.getFecha());
            return ResponseEntity.ok(notaRepository.save(updatedNota));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable int id) {
        if (notaRepository.existsById(id)) {
            notaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}