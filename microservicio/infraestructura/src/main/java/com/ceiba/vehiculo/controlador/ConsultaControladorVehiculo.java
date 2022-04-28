package com.ceiba.vehiculo.controlador;

import com.ceiba.vehiculo.consulta.ManejadorListarVehiculos;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@Api(tags={"Controlador consulta vehiculo"})
public class ConsultaControladorVehiculo {
    private final ManejadorListarVehiculos  manejadorListarVehiculos;

    public ConsultaControladorVehiculo(ManejadorListarVehiculos manejadorListarVehiculos) {
        this.manejadorListarVehiculos = manejadorListarVehiculos;
    }

    @GetMapping
    @ApiOperation("Listar Vehiculos")
    public List<DtoVehiculo> listar() {
        return this.manejadorListarVehiculos.ejecutar();
    }

}
