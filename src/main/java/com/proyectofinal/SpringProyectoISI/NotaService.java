package com.proyectofinal.SpringProyectoISI;


import com.proyectofinal.SpringProyectoISI.model.Nota;
import com.proyectofinal.SpringProyectoISI.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    public Optional<Nota> getNotaById(int id) {
        return notaRepository.findById(id);
    }

    public Nota saveNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public void deleteNota(int id) {
        notaRepository.deleteById(id);
    }

    public Nota updateNota(int id, Nota notaDetails) {
        Optional<Nota> notaOptional = notaRepository.findById(id);
        if (notaOptional.isPresent()) {
            Nota nota = notaOptional.get();
            nota.setInscripcion(notaDetails.getInscripcion());
            nota.setTarea(notaDetails.getTarea());
            nota.setCalificacion(notaDetails.getCalificacion());
            nota.setTipoEvaluacion(notaDetails.getTipoEvaluacion());
            nota.setFecha(notaDetails.getFecha());
            return notaRepository.save(nota);
        } else {
            return null;
        }
    }
}
