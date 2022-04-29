package com.ceiba.tiposervicio.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import lombok.Getter;

@Getter
public class TipoServicio {

    private static final String DEBE_INGRESAR_EL_NOMBRE = "El nombre es obligatorio";
    private Long id;
    private String nombre;
    public TipoServicio(Long id, String nombre){
        validarObligatorio(nombre,DEBE_INGRESAR_EL_NOMBRE);
        this.id=id;
        this.nombre=nombre;
    }
}
