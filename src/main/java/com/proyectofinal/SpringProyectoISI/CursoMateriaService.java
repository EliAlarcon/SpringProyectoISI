package com.proyectofinal.SpringProyectoISI;

import com.proyectofinal.SpringProyectoISI.model.CursoMateria;
import com.proyectofinal.SpringProyectoISI.repository.CursoMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoMateriaService {

    @Autowired
    private CursoMateriaRepository cursoMateriaRepository;

    public List<CursoMateria> getAllCursoMaterias() {
        return cursoMateriaRepository.findAll();
    }

    public Optional<CursoMateria> getCursoMateriaById(int id) {
        return cursoMateriaRepository.findById(id);
    }

    public CursoMateria saveCursoMateria(CursoMateria cursoMateria) {
        return cursoMateriaRepository.save(cursoMateria);
    }

    public void deleteCursoMateria(int id) {
        cursoMateriaRepository.deleteById(id);
    }

    public CursoMateria updateCursoMateria(int id, CursoMateria cursoMateriaDetails) {
        Optional<CursoMateria> cursoMateriaOptional = cursoMateriaRepository.findById(id);
        if (cursoMateriaOptional.isPresent()) {
            CursoMateria cursoMateria = cursoMateriaOptional.get();
            cursoMateria.setCurso(cursoMateriaDetails.getCurso());
            cursoMateria.setMateria(cursoMateriaDetails.getMateria());
            return cursoMateriaRepository.save(cursoMateria);
        } else {
            return null;
        }
    }
}