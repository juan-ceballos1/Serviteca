package com.ceiba.asistencia.servicio;

import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioEliminarAsistencia {

    private static final String LA_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA = "La asistencia no existe en el sistema";
    private final RepositorioAsistencia repositorioAsistencia;

    public ServicioEliminarAsistencia(RepositorioAsistencia repositorioAsistencia) {
        this.repositorioAsistencia = repositorioAsistencia;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioAsistencia.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioAsistencia.existePorId(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_ASISTENCIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
