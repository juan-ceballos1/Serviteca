package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public class ComandoVehiculoTestDataBuilder {
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;

    public ComandoVehiculoTestDataBuilder() {
        matricula = "1234";
        marca = "marca a";
        modelo = "centra";
    }

    public ComandoVehiculoTestDataBuilder conMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public ComandoVehiculoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoVehiculoTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public ComandoVehiculoTestDataBuilder conModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public ComandoVehiculo build() {
        return new ComandoVehiculo(id,matricula, marca,modelo);
    }
}
