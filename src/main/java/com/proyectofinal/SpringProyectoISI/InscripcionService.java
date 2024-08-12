package com.proyectofinal.SpringProyectoISI;

import com.proyectofinal.SpringProyectoISI.model.Inscripcion;
import com.proyectofinal.SpringProyectoISI.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Optional<Inscripcion> getInscripcionById(int id) {
        return inscripcionRepository.findById(id);
    }

    public Inscripcion saveInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public void deleteInscripcion(int id) {
        inscripcionRepository.deleteById(id);
    }

    public Inscripcion updateInscripcion(int id, Inscripcion inscripcionDetails) {
        Optional<Inscripcion> inscripcionOptional = inscripcionRepository.findById(id);
        if (inscripcionOptional.isPresent()) {
            Inscripcion inscripcion = inscripcionOptional.get();
            inscripcion.setEstudiante(inscripcionDetails.getEstudiante());
            inscripcion.setCurso(inscripcionDetails.getCurso());
            inscripcion.setFechaInscripcion(inscripcionDetails.getFechaInscripcion());
            return inscripcionRepository.save(inscripcion);
        } else {
            return null;
        }
    }
}