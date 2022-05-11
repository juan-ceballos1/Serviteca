package com.ceiba.asistencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
public class ServicioCrearAsistencia {
    private static final String EL_TIPO_DE_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA = "El tipo de asistencia no existe en el sistema";

    private final RepositorioAsistencia repositorioAsistencia;
    private final DaoTipoAsistencia daoTipoAsistencia;

    public ServicioCrearAsistencia(RepositorioAsistencia repositorioAsistencia, DaoTipoAsistencia daoTipoAsistencia) {
        this.repositorioAsistencia = repositorioAsistencia;
        this.daoTipoAsistencia = daoTipoAsistencia;
    }

    public Long ejecutar(Asistencia asistencia) {
        DtoTipoAsistencia dtoTipoAsistencia = obtenerTipoServicio(asistencia.getIdTipoAsistencia());
        asistencia.asignarPrecio(dtoTipoAsistencia.getNombre());
        asistencia.validarFechaFin(dtoTipoAsistencia.getNombre());
       return this.repositorioAsistencia.crear(asistencia);
    }

    private DtoTipoAsistencia obtenerTipoServicio(Long idTipoServicio){
        try {
            DtoTipoAsistencia dtoTipoAsistencia=daoTipoAsistencia.consultarPorId(idTipoServicio);

            return  daoTipoAsistencia.consultarPorId(idTipoServicio);
        }catch (Exception e){
            throw new ExcepcionDuplicidad(EL_TIPO_DE_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA);
        }

    }
}
