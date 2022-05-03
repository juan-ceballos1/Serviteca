package com.ceiba.asistencia.modelo.entidad;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Asistencia {

    private static final String SE_DEBE_INGRESAR_EL_TIPO_SERVICIO = "Se debe ingresar el tipo de servicio";
    private static final String SE_DEBE_INGRESAR_EL_VEHICULO= "Se debe ingresar el vehiculo";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO= "Se debe ingresar la fecha inicio";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO= "Se debe ingresar el precio";
    private static final String PRECIO_MAYOR_A_CERO= "El precio debe ser mayor a 0";
    private static final String FECHA_NO_DEBE_SER_MENOR_A_LA_INICIAL = "La fecha de finalizacion no debe ser menor a la de inicio";
    private static final String LAVADO = "lavado";
    private static final String CAMBIO_DE_ACEITE = "cambio de aceite";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN = "Se debe ingresar la fecha de finalizacion";
    private static final double PORCENTAJE_DE_AUMENTO = 0.3;

    private Long id;
    private Long idTipoAsistencia;
    private Long idVehiculo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double precio;

    public Asistencia(Long id, Long idTipoAsistencia, Long idVehiculo, LocalDateTime fechaInicio, LocalDateTime fechaFin, double precio) {
        validarObligatorio(idTipoAsistencia,SE_DEBE_INGRESAR_EL_TIPO_SERVICIO);
        validarObligatorio(idVehiculo,SE_DEBE_INGRESAR_EL_VEHICULO);
        validarObligatorio(fechaInicio,SE_DEBE_INGRESAR_LA_FECHA_INICIO);
        validarObligatorio(precio,SE_DEBE_INGRESAR_EL_PRECIO);
        validarPositivo(precio,PRECIO_MAYOR_A_CERO);

        this.id = id;
        this.idTipoAsistencia = idTipoAsistencia;
        this.idVehiculo = idVehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
    }

    public void asignarPrecio(String nombre){
        if(validarLavadoOCambioDeAceite(nombre)&&fechaMartesOViernes()){
            setPrecio(precio+precio*PORCENTAJE_DE_AUMENTO);
        }
    }
    public void validarFechaFin(String nombre){
        if(validarLavadoOCambioDeAceite(nombre)){
            setFechaFin(fechaInicio);
        }
        else {
            validarObligatorio(fechaFin,SE_DEBE_INGRESAR_LA_FECHA_FIN);
            validarMenor(fechaInicio, fechaFin,FECHA_NO_DEBE_SER_MENOR_A_LA_INICIAL);
        }
    }
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    private boolean fechaMartesOViernes(){
        return fechaInicio.toLocalDate().getDayOfWeek()== DayOfWeek.TUESDAY|| fechaInicio.toLocalDate().getDayOfWeek()==DayOfWeek.FRIDAY;
    }
    private boolean validarLavadoOCambioDeAceite(String nombre){
        return LAVADO.equalsIgnoreCase(nombre)||CAMBIO_DE_ACEITE.equalsIgnoreCase(nombre);
    }
}
