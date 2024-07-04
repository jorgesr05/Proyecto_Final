package com.proyecto.final_project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.final_project.models.Cuenta;
import com.proyecto.final_project.repositories.CuentaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuentaServices {
    private final CuentaRepository cuentaRepository;

    //Búsqueda de lista de cuentas
    public List<Cuenta> mostrarTodo(){
        return cuentaRepository.findAll();
    }

    //Búsqueda por cuenta
    public Cuenta encontrarId(Long id){
        return cuentaRepository.findById(id).orElse(null);
    }

    //Crear un cuenta
    public Cuenta crearCuenta(Cuenta cliente){
        return cuentaRepository.save(cliente);
    }

    //Actualizar cuenta
    public Cuenta actualizarCuenta(Cuenta cliente){
        return cuentaRepository.save(cliente);
    }

    //Eliminar cuenta
    public void eliminarCuenta(Long id){
        cuentaRepository.deleteById(id);
    }


    
}
