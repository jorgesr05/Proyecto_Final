package com.proyecto.final_project.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
public class Cliente extends BaseModel {

    @NotNull
    @Size(min = 4)
    private String nombre; //registrar nombre y apellido


    @NotNull
    private Boolean nacional; //para validar si tiene DNI o carnet de extranjería
    
    //cambiar el TRUE por el Sí para aplicar ello en el postman
    
   /*  public String getNacionalComoTexto(){
        return nacional ? "Sí" : "No";
    }

    public void setNacionalDesdeTexto(String texto){
        this.nacional = "Sí".equalsIgnoreCase(texto);
    } */

    @NotNull
    private String documento;//Si previamente responde SÍ, entonces colocará su DNI caso contrario su carnet de extranjería

    @NotNull
    @Email
    private String correo;
    
    @NotNull
    @Size(min = 9, max = 9)
    private String celular;
    
    @NotNull
    @Past
    private Date cumpleaños;
    
    
    @Size(min = 5, max = 10)
    @NotEmpty
    private String contraseña;
    
    @Size(min = 5, max = 10)
    @NotEmpty
    private String confirmarContraseña;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Cuenta> cuentas;
}
