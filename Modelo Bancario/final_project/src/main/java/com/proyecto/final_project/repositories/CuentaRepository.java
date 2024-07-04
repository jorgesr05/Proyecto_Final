package com.proyecto.final_project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.final_project.models.Cuenta;

@Repository
public interface CuentaRepository extends CrudRepository <Cuenta, Long>{

    //Buscar de cuentas
    List<Cuenta> findAll();

    //Buscar por id
    Optional<Cuenta> findById(Long id);
    
}
