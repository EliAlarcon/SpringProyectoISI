package com.proyectofinal.SpringProyectoISI;

import com.proyectofinal.SpringProyectoISI.model.Administrador;
import com.proyectofinal.SpringProyectoISI.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> getAllAdministradores() {
        return administradorRepository.findAll();
    }

    public Optional<Administrador> getAdministradorById(int id) {
        return administradorRepository.findById(id);
    }

    public Administrador saveAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public void deleteAdministrador(int id) {
        administradorRepository.deleteById(id);
    }

    public Administrador updateAdministrador(int id, Administrador administradorDetails) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);
        if (administradorOptional.isPresent()) {
            Administrador administrador = administradorOptional.get();
            administrador.setUsuario(administradorDetails.getUsuario());
            return administradorRepository.save(administrador);
        } else {
            return null;
        }
    }
}