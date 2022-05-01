package com.ceiba.vehiculo.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Vehiculo {

    private static final String SE_DEBE_INGRESAR_LA_MATRICULA = "Se debe ingresar la matricula";
    private static final String LA_MATRICULA_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La matricula debe tener una longitud mayor o igual a 4";
    private static final String SE_DEBE_INGRESAR_LA_MARCA = "Se debe ingresar la marca";
    private static final String SE_DEBE_INGRESAR_EL_MODELO= "Se debe ingresar el modelo";

    private static final int LONGITUD_MINIMA_MATRICULA=4;
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo(Long id,String matricula,String marca, String modelo){
        validarObligatorio(matricula,SE_DEBE_INGRESAR_LA_MATRICULA);
        validarLongitud(matricula,LONGITUD_MINIMA_MATRICULA,LA_MATRICULA_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A);
        validarObligatorio(marca,SE_DEBE_INGRESAR_LA_MARCA);
        validarObligatorio(modelo,SE_DEBE_INGRESAR_EL_MODELO);
        this.id = id;
        this.matricula= matricula;
        this.marca=marca;
        this.modelo=modelo;
    }
}
