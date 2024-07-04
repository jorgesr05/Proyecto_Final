package com.proyecto.final_project.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.final_project.models.Cliente;
import com.proyecto.final_project.services.ClienteServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cliente")
@AllArgsConstructor
public class ClienteApi {
    
    private final ClienteServices clienteServices;

    //Nombrar clientes
    @GetMapping("")
    public List<Cliente> mostrarCliente(){
        return clienteServices.mostrarTodo();
    }

    //Buscar cliente por id
    @GetMapping("/{id}")
    public Cliente encontrarCliente(@PathVariable("id") Long id){
        return clienteServices.encontrarId(id);
    }

    //Crear cliente
    @PostMapping()
    public Cliente crearCliente(@RequestParam("nombre") String nombre, @RequestParam("nacional") Boolean nacional,@RequestParam("documento") String documento, @RequestParam("correo") String correo,@RequestParam("celular") String celular, @RequestParam("cumpleaños") String cumpleaños, @RequestParam("contraseña") String contraseña, @RequestParam("confirmarContraseña") String confirmarContraseña){
        Cliente cliente = new Cliente(nombre,nacional,documento, correo, celular, new Date(cumpleaños),contraseña,confirmarContraseña,null);
        return clienteServices.crearCliente(cliente);
    }

    //Actualizar cliente
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable("id")Long id,@RequestParam("nombre") String nombre, @RequestParam("nacional") Boolean nacional,@RequestParam("documento") String documento, @RequestParam("correo") String correo,@RequestParam("celular") String celular, @RequestParam("cumpleaños") String cumpleaños, @RequestParam("contraseña") String contraseña, @RequestParam("confirmarContraseña") String confirmarContraseña){
        Cliente cliente = clienteServices.encontrarId(id);
        cliente.setNombre(nombre);
        return clienteServices.actualizarCliente(cliente);
    }

    //Eliminar cliente
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable("id") Long id){
        clienteServices.eliminarCliente(id);
    }

  



}
