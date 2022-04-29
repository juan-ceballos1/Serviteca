package com.ceiba.asistencia.puerto.repositorio;

import com.ceiba.asistencia.modelo.entidad.Asistencia;

public interface RepositorioAsistencia {
    /**
     * Permite crear un tipoServicio
     * @param asistencia
     * @return el id generado
     */
    Long crear(Asistencia asistencia);

    /**
     * Permite actualizar un TipoServicio
     * @param asistencia
     */
    void actualizar(Asistencia asistencia);

    /**
     * Permite eliminar un TipoServicio
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un Servicio con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
