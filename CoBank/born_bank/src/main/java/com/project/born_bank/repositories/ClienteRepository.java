package com.project.born_bank.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.born_bank.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
    //Buscar clientes
    List<Cliente> findAll();

    //Buscar por id
    Optional<Cliente> findById(Long id);
    
}
