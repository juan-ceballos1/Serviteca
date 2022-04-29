package com.ceiba.asistencia.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
@Getter
public class Asistencia {

    private static final String SE_DEBE_INGRESAR_EL_TIPO_SERVICIO = "Se debe ingresar el tipo de servicio";
    private static final String SE_DEBE_INGRESAR_EL_VEHICULO= "Se debe ingresar el vehiculo";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO= "Se debe ingresar la fecha inicio";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO= "Se debe ingresar el precio";
    private static final String PRECIO_MAYOR_A_CERO= "El precio debe ser mayor a 0";
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

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
