package com.proyectofinal.SpringProyectoISI;

import com.proyectofinal.SpringProyectoISI.model.Profesor;
import com.proyectofinal.SpringProyectoISI.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> getProfesorById(int id) {
        return profesorRepository.findById(id);
    }

    public Profesor saveProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void deleteProfesor(int id) {
        profesorRepository.deleteById(id);
    }

    public Profesor updateProfesor(int id, Profesor profesorDetails) {
        Optional<Profesor> profesorOptional = profesorRepository.findById(id);
        if (profesorOptional.isPresent()) {
            Profesor profesor = profesorOptional.get();
            profesor.setEspecialidad(profesorDetails.getEspecialidad());
            profesor.setUsuario(profesorDetails.getUsuario());
            profesor.setMaterias(profesorDetails.getMaterias());
            return profesorRepository.save(profesor);
        } else {
            return null;
        }
    }
}