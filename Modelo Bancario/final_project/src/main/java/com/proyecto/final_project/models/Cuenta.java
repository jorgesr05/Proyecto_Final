package com.proyecto.final_project.models;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "cuentas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cuenta extends BaseModel{

    @NotNull
    private String entidad;

    @NotNull
    private Boolean soles;

    @NotNull
    private String tipo;

    @NotNull
    @NumberFormat
    private Integer importe;
 
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public void setMoneda(Boolean moneda) {
        throw new UnsupportedOperationException("Unimplemented method 'setMoneda'");
    }
}
