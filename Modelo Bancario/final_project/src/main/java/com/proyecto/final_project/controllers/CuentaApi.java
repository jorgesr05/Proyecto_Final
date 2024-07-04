package com.proyecto.final_project.controllers;

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
import com.proyecto.final_project.models.Cuenta;
import com.proyecto.final_project.services.ClienteServices;
import com.proyecto.final_project.services.CuentaServices;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/cuenta")
@AllArgsConstructor
public class CuentaApi {

    private final CuentaServices cuentaServices;
    private final ClienteServices clienteServices;

    //Nombrar cuentas
    @GetMapping("")
    public List<Cuenta> mostrarCuenta(){
        return cuentaServices.mostrarTodo();
    }

    //Buscar por id de cuenta
    @GetMapping("/{id}")
    public Cuenta encontrarCuenta(@PathVariable("id") Long id){
        return cuentaServices.encontrarId(id);
    }

    //Crear cuenta
    @PostMapping("")
    public Cuenta crearCuenta(@RequestParam("entidad")String entidad, @RequestParam("moneda") Boolean moneda, @RequestParam("tipo") String tipo, @RequestParam("importe") Integer importe, @RequestParam("clienteId") Long clienteId){
        Cliente encontrarCliente = clienteServices.encontrarId(clienteId);
        if(encontrarCliente == null){
            return null;
        }
        Cuenta cuentas = new Cuenta(entidad, moneda, tipo, importe,encontrarCliente);
        return cuentaServices.crearCuenta(cuentas);
    }

    //Actualizar cuenta
    @PutMapping("/{id}")
    public Cuenta actualizarCuenta(@PathVariable("id") Long id, @RequestParam("entidad")String entidad, @RequestParam("moneda") Boolean moneda, @RequestParam("tipo") String tipo, @RequestParam("importe") Integer importe,@RequestParam("clienteId") Long clienteId){
        Cliente encontrarCliente = clienteServices.encontrarId(clienteId);
        if(encontrarCliente == null){
            return null;
        }
        Cuenta cuentas = cuentaServices.encontrarId(id);
        cuentas.setImporte(importe);
        cuentas.setMoneda(moneda);//Para determinar si queremos ingresar más soles o dólares
        return cuentaServices.actualizarCuenta(cuentas);
    }


    //Eliminar cuenta
    @DeleteMapping("/{id}")
    public void eliminarCuenta(@PathVariable("id")Long id){
        cuentaServices.eliminarCuenta(id);
    }




    
}
