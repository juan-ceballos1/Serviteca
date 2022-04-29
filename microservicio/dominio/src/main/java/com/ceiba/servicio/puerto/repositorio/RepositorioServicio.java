package com.ceiba.servicio.puerto.repositorio;

import com.ceiba.servicio.modelo.entidad.Servicio;

public interface RepositorioServicio {
    /**
     * Permite crear un tipoServicio
     * @param servicio
     * @return el id generado
     */
    Long crear(Servicio servicio);

    /**
     * Permite actualizar un TipoServicio
     * @param servicio
     */
    void actualizar(Servicio servicio);

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
