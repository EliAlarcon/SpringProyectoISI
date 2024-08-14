package com.proyectofinal.SpringProyectoISI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.SpringProyectoISI.model.Promedio;
import com.proyectofinal.SpringProyectoISI.repository.PromedioRepository;

@Service
public class PromedioService {

    @Autowired
    private PromedioRepository promedioRepository;

    public List<Promedio> getAllPromedios(){
        return promedioRepository.findAll();
    }

    public Optional<Promedio> getPromedioById(int id){
        return promedioRepository.findById(id);
    }

    public Promedio savePromedio(Promedio promedio){
        return promedioRepository.save(promedio);
    }

    public void deletePromedio(int id){
        promedioRepository.deleteById(id);
    }

    public Promedio updatePromedio(Promedio promedio){
        return promedioRepository.save(promedio);
    }
}
