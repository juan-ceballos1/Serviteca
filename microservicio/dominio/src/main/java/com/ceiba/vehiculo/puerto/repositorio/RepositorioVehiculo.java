package com.ceiba.vehiculo.puerto.repositorio;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {
    /**
     * Permite crear un vehiculo
     * @param vehiculo
     * @return el id generado
     */
    Long crear(Vehiculo vehiculo);

    /**
     * Permite actualizar un Vehiculo
     * @param vehiculo
     */
    void actualizar(Vehiculo vehiculo);

    /**
     * Permite eliminar un vehiculo
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un vehiculo con una matricula
     * @param matricula
     * @return si existe o no
     */
    boolean existe(String matricula);

    /**
     * Permite validar si existe un Vehiculo con un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
