package com.project.born_bank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto extends ModeloMatriz{

    private String ahorro;
    private String debito;
    private String credito;
    private String afp;
    private String plazoFijo;
    
}
 