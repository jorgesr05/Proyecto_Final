package com.project.born_bank.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends ModeloMatriz{

    @NotNull
    @Size(min = 4)
    private String nombre;
    
    @NotNull
    private String documento;
    
    @NotNull
    @Email
    private String correo;
    
    @NotNull
    @Size(min = 9, max = 9)
    private String celular;
    
    @NotNull
    @Past
    private Date cumpleaños;
    
    @Size(min = 8, max = 8)
    @NotEmpty
    private String clave;
    
    @Size(min = 8, max = 8)
    @NotEmpty
    private String confirClave;
    
}
