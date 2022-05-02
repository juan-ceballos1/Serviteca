package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioEliminarVehiculo {

    private static final String EL_VEHICULO_NO_EXISTE_EN_EL_SISTEMA = "El vehiculo no existe en el sistema";
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioVehiculo.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioVehiculo.existePorId(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_VEHICULO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
