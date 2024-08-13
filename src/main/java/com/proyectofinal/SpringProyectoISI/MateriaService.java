package com.proyectofinal.SpringProyectoISI;

import com.proyectofinal.SpringProyectoISI.model.Materia;
import com.proyectofinal.SpringProyectoISI.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> getMateriaById(int id) {
        return materiaRepository.findById(id);
    }

    public Materia saveMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void deleteMateria(int id) {
        materiaRepository.deleteById(id);
    }

    public Materia updateMateria(int id, Materia materiaDetails) {
        Optional<Materia> materiaOptional = materiaRepository.findById(id);
        if (materiaOptional.isPresent()) {
            Materia materia = materiaOptional.get();
            materia.setNombre(materiaDetails.getNombre());
            materia.setDescripcion(materiaDetails.getDescripcion());
            materia.setProfesor(materiaDetails.getProfesor());
            return materiaRepository.save(materia);
        } else {
            return null;
        }
    }
}