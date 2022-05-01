package com.ceiba.tipoasistencia.puerto.repositorio;

import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;

public interface RepositorioTipoAsistencia {
    /**
     * Permite crear un tipoServicio
     * @param tipoAsistencia
     * @return el id generado
     */
    Long crear(TipoAsistencia tipoAsistencia);

    /**
     * Permite actualizar un TipoServicio
     * @param tipoAsistencia
     */
    void actualizar(TipoAsistencia tipoAsistencia);

    /**
     * Permite eliminar un TipoServicio
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un TipoServicio con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un TipoServicio con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
