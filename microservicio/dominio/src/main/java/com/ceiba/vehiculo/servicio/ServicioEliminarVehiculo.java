package com.ceiba.vehiculo.servicio;

import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioEliminarVehiculo {
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public void ejecutar(Long id) {
        this.repositorioVehiculo.eliminar(id);
    }
}
