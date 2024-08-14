package com.proyectofinal.SpringProyectoISI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectofinal.SpringProyectoISI.model.Carrera;
import com.proyectofinal.SpringProyectoISI.repository.CarreraRepository;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> getAllCarreras() {
        return carreraRepository.findAll();
    }

    public Optional<Carrera> getCarreraById(int id) {
        return carreraRepository.findById(id);
    }

    public Carrera saveCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public void deleteCarrera(int id) {
        carreraRepository.deleteById(id);
    }

    public Carrera updateCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }
}