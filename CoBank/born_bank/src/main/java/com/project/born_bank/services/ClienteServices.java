package com.project.born_bank.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.born_bank.models.Cliente;
import com.project.born_bank.repositories.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServices {
    private final ClienteRepository clienteRepository;
    
    //Buscar por todos los clientes
    public List<Cliente> mostrarTodo(){
        return clienteRepository.findAll();
    }

    //Buscar por id
    public Cliente encontrarId(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    //Crear un cliente
    public Cliente crearCliente(Cliente cliente){
        //validar contraseñas
        if(!cliente.getClave().equals(cliente.getConfirClave())){
            throw new IllegalArgumentException("Contraseñas no son iguales");
        }
            return clienteRepository.save(cliente);
    }

    //Actualizar cliente
    public Cliente actualizarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //Eliminar cliente
    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }







}
