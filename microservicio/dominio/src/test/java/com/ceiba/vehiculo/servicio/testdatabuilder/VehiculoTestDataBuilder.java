package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public class VehiculoTestDataBuilder {
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;

    public VehiculoTestDataBuilder() {
        matricula = "1234";
        marca = "marca a";
        modelo = "centra";
    }

    public VehiculoTestDataBuilder conMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public VehiculoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public VehiculoTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public VehiculoTestDataBuilder conModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public Vehiculo build() {
        return new Vehiculo(id,matricula, marca,modelo);
    }
}
