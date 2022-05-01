package com.ceiba.asistencia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;

public class ServicioActualizarAsistencia {
    private static final String LA_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA = "La asistencia no existe en el sistema";
    private final RepositorioAsistencia repositorioAsistencia;

    public ServicioActualizarAsistencia(RepositorioAsistencia repositorioAsistencia) {
        this.repositorioAsistencia = repositorioAsistencia;
    }

    public void ejecutar(Asistencia asistencia) {
        validarExistenciaPrevia(asistencia);
        this.repositorioAsistencia.actualizar(asistencia);
    }

    private void validarExistenciaPrevia(Asistencia asistencia) {
        boolean existe = this.repositorioAsistencia.existePorId(asistencia.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
