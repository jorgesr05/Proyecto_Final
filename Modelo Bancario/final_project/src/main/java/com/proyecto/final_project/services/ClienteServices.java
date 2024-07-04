package com.proyecto.final_project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.final_project.models.Cliente;
import com.proyecto.final_project.repositories.ClienteRepository;

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
        if(!cliente.getContraseña().equals(cliente.getConfirmarContraseña())){
            throw new IllegalArgumentException("Contraseñas no son iguales");
        }
            return clienteRepository.save(cliente);
    }
    
    /* public Cliente actualizarNacionalidadCliente(Long id, String nacional){
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if(clienteOpt.isPresent()){
            Cliente cliente = clienteOpt.get();
            cliente.setNacional(convertirTextoABooleano(nacional));
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public String obtenerNacionalidadCliente(Long id){
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if(clienteOpt.isPresent()){
            Cliente cliente = clienteOpt.get();
            return convertirBooleanoATexto(cliente.getNacional());
        }
        else{
            return "No encontrado";
        }
    }

    private boolean convertirTextoABooleano(String texto) {
        return "SÍ".equalsIgnoreCase(texto);
    }

    private String convertirBooleanoATexto(boolean valor) {
        return valor ? "SÍ" : "NO";
    } */


    //Actualizar cliente
    public Cliente actualizarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //Eliminar cliente
    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }

}
