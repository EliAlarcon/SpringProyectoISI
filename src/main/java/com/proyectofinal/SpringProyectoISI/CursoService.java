package com.proyectofinal.SpringProyectoISI;

import com.proyectofinal.SpringProyectoISI.model.Curso;
import com.proyectofinal.SpringProyectoISI.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(int id) {
        return cursoRepository.findById(id);
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deleteCurso(int id) {
        cursoRepository.deleteById(id);
    }

    public Curso updateCurso(int id, Curso cursoDetails) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            curso.setNombre(cursoDetails.getNombre());
            curso.setDescripcion(cursoDetails.getDescripcion());
            curso.setProfesor(cursoDetails.getProfesor());
            return cursoRepository.save(curso);
        } else {
            return null;
        }
    }
}