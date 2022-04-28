package com.ceiba.tiposervicio.puerto.repositorio;

import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;

public interface RepositorioTipoServicio {
    /**
     * Permite crear un tipoServicio
     * @param tipoServicio
     * @return el id generado
     */
    Long crear(TipoServicio tipoServicio);

    /**
     * Permite actualizar un TipoServicio
     * @param tipoServicio
     */
    void actualizar(TipoServicio tipoServicio);

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
