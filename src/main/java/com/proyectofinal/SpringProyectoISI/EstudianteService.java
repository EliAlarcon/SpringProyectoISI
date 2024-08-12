package com.proyectofinal.SpringProyectoISI;

import com.proyectofinal.SpringProyectoISI.model.Estudiante;
import com.proyectofinal.SpringProyectoISI.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getEstudianteById(int id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante saveEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void deleteEstudiante(int id) {
        estudianteRepository.deleteById(id);
    }

    public Estudiante updateEstudiante(int id, Estudiante estudianteDetails) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
        if (estudianteOptional.isPresent()) {
            Estudiante estudiante = estudianteOptional.get();
            estudiante.setCarrera(estudianteDetails.getCarrera());
            estudiante.setUsuario(estudianteDetails.getUsuario());
            return estudianteRepository.save(estudiante);
        } else {
            return null;
        }
    }
}