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
    private static final String LA_ASISTENCIA_YA_EXISTE_EN_EL_SISTEMA = "La asistencia ya existe en el sistema";
    private static final String EL_TIPO_DE_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA = "El tipo de asistencia no existe en el sistema";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN = "Se debe ingresar la fecha de finalizacion";
    private static final String FECHA_NO_DEBE_SER_MENOR_A_LA_INICIAL = "La fecha de finalizacion no debe ser menor a la de inicio";
    private static final String LOS_DOMINGOS_NO_HAY_SERVICIO = "Los domingos no hay servicio";
    private static final String LAVADO = "lavado";
    private static final String CAMBIO_DE_ACEITE = "cambio de aceite";
    private static final double PORCENTAJE_DE_AUMENTO = 0.3;

    private final RepositorioAsistencia repositorioAsistencia;
    private final DaoTipoAsistencia daoTipoAsistencia;
    private final RepositorioTipoAsistencia repositorioTipoAsistencia;

    public ServicioCrearAsistencia(RepositorioAsistencia repositorioAsistencia, DaoTipoAsistencia daoTipoAsistencia, RepositorioTipoAsistencia repositorioTipoAsistencia) {
        this.repositorioAsistencia = repositorioAsistencia;
        this.daoTipoAsistencia = daoTipoAsistencia;
        this.repositorioTipoAsistencia = repositorioTipoAsistencia;
    }

    public Long ejecutar(Asistencia asistencia) {
        verificarSiDomingo(asistencia.getFechaInicio());
        DtoTipoAsistencia dtoTipoAsistencia = obtenerTipoServicio(asistencia.getIdTipoAsistencia());
        if(validarLavadoOCambioDeAceite(dtoTipoAsistencia.getNombre())){
            asistencia.setFechaFin(asistencia.getFechaInicio());
            aumentarPrecioSiFechaMartesOViernes(asistencia);
        }
        else{
            validarObligatorio(asistencia.getFechaFin(),SE_DEBE_INGRESAR_LA_FECHA_FIN);
            validarMenor(asistencia.getFechaInicio(), asistencia.getFechaFin(),FECHA_NO_DEBE_SER_MENOR_A_LA_INICIAL);
        }
       return this.repositorioAsistencia.crear(asistencia);
    }

    private void verificarSiDomingo(LocalDateTime fecha){
        if(fecha.toLocalDate().getDayOfWeek()==DayOfWeek.SUNDAY){
            throw  new ExcepcionValorInvalido(LOS_DOMINGOS_NO_HAY_SERVICIO);
        }
    }

    private void aumentarPrecioSiFechaMartesOViernes(Asistencia asistencia){
        if(asistencia.getFechaInicio().toLocalDate().getDayOfWeek()== DayOfWeek.TUESDAY|| asistencia.getFechaInicio().toLocalDate().getDayOfWeek()==DayOfWeek.FRIDAY){
            double precio= asistencia.getPrecio();
            asistencia.setPrecio(precio+precio*PORCENTAJE_DE_AUMENTO);
        }
    }
    private boolean validarLavadoOCambioDeAceite(String nombre){
        return LAVADO.equalsIgnoreCase(nombre)||CAMBIO_DE_ACEITE.equalsIgnoreCase(nombre);
    }

    private DtoTipoAsistencia obtenerTipoServicio(Long idTipoServicio){
        boolean existe = this.repositorioTipoAsistencia.existePorId(idTipoServicio);
        if(existe){
            return  daoTipoAsistencia.consultarPorId(idTipoServicio);
        }
       throw new ExcepcionDuplicidad(EL_TIPO_DE_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA);
    }
}
