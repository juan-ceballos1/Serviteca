package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import com.ceiba.tiposervicio.puerto.dao.DaoTipoServicio;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
public class ServicioCrearServicio {
    private static final String EL_SERVICIO_YA_EXISTE_EN_EL_SISTEMA = "El servicio ya existe en el sistema";
    private static final String EL_TIPO_SERVICIO_NO_EXISTE = "El tipo de servicio no existe en el sistema";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN = "Se debe ingresar la fecha de finalizacion";
    private static final String FECHA_NO_DEBE_SER_MENOR_A_LA_INICIAL = "Se debe ingresar la fecha de finalizacion";
    private static final String LOS_DOMINGOS_NO_HAY_SERVICIO = "Los domingos no hay servicio";
    private static final String LAVADO = "lavado";
    private static final String CAMBIO_DE_ACEITE = "cambio de aceite";

    private final RepositorioServicio repositorioServicio;
    private final DaoTipoServicio daoTipoServicio;
    private final RepositorioTipoServicio repositorioTipoServicio;

    public ServicioCrearServicio(RepositorioServicio repositorioServicio, DaoTipoServicio daoTipoServicio, RepositorioTipoServicio repositorioTipoServicio) {
        this.repositorioServicio = repositorioServicio;
        this.daoTipoServicio = daoTipoServicio;
        this.repositorioTipoServicio = repositorioTipoServicio;
    }

    public Long ejecutar(Servicio servicio) {
        validarExistenciaPrevia(servicio);
        verificarSiDomingo(servicio.getFechaInicio());
        DtoTipoServicio dtoTipoServicio = obtenerTipoServicio(servicio.getIdTipoServicio());
        if(validarLavadoOCambioDeAceite(dtoTipoServicio.getNombre())){
            servicio.setFechaFin(servicio.getFechaInicio());
            aumentarPrecioSiFechaMartesOViernes(servicio);
        }
        else{
            validarObligatorio(servicio.getFechaFin(),SE_DEBE_INGRESAR_LA_FECHA_FIN);
            validarMenor(servicio.getFechaInicio(),servicio.getFechaFin(),FECHA_NO_DEBE_SER_MENOR_A_LA_INICIAL);
        }
       return this.repositorioServicio.crear(servicio);
    }

    private void validarExistenciaPrevia(Servicio servicio) {
        boolean existe = this.repositorioServicio.existePorId(servicio.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_SERVICIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void verificarSiDomingo(LocalDateTime fecha){
        if(fecha.toLocalDate().getDayOfWeek()==DayOfWeek.SUNDAY){
            throw  new ExcepcionValorInvalido(LOS_DOMINGOS_NO_HAY_SERVICIO);
        }
    }

    private void aumentarPrecioSiFechaMartesOViernes(Servicio servicio){
        if(servicio.getFechaInicio().toLocalDate().getDayOfWeek()== DayOfWeek.FRIDAY||servicio.getFechaInicio().toLocalDate().getDayOfWeek()==DayOfWeek.TUESDAY){
            double precio= servicio.getPrecio();
            servicio.setPrecio(precio+precio*0.3);
        }
    }
    private boolean validarLavadoOCambioDeAceite(String nombre){
        return LAVADO.equalsIgnoreCase(nombre)||CAMBIO_DE_ACEITE.equalsIgnoreCase(nombre);
    }

    private DtoTipoServicio obtenerTipoServicio(Long idTipoServicio){
        boolean existe = this.repositorioTipoServicio.existePorId(idTipoServicio);
        if(existe){
            return  daoTipoServicio.consultarPorId(idTipoServicio);
        }
       throw new ExcepcionDuplicidad(EL_TIPO_SERVICIO_NO_EXISTE);
    }
}
