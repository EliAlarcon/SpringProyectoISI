package com.proyectofinal.SpringProyectoISI.services;

import com.proyectofinal.SpringProyectoISI.model.Tarea;
import com.proyectofinal.SpringProyectoISI.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> getTareaById(int id) {
        return tareaRepository.findById(id);
    }

    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void deleteTarea(int id) {
        tareaRepository.deleteById(id);
    }

    public Tarea updateTarea(int id, Tarea tareaDetails) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        if (tareaOptional.isPresent()) {
            Tarea tarea = tareaOptional.get();
            tarea.setNombre(tareaDetails.getNombre());
            tarea.setDescripcion(tareaDetails.getDescripcion());
            return tareaRepository.save(tarea);
        } else {
            return null;
        }
    }
}
