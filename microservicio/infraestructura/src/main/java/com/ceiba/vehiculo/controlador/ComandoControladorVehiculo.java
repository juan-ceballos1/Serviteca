package com.ceiba.vehiculo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.comando.manejador.ManejadorActualizarVehiculo;
import com.ceiba.vehiculo.comando.manejador.ManejadorCrearVehiculo;
import com.ceiba.vehiculo.comando.manejador.ManejadorEliminarVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
@Api(tags = { "Controlador comando vehiculos"})
public class ComandoControladorVehiculo {
    private final ManejadorCrearVehiculo manejadorCrearVehiculo;
    private final ManejadorEliminarVehiculo manejadorEliminarVehiculo;
    private final ManejadorActualizarVehiculo manejadorActualizarVehiculo;

    @Autowired
    public ComandoControladorVehiculo(ManejadorCrearVehiculo manejadorCrearVehiculo, ManejadorEliminarVehiculo manejadorEliminarVehiculo, ManejadorActualizarVehiculo manejadorActualizarVehiculo) {
        this.manejadorCrearVehiculo = manejadorCrearVehiculo;
        this.manejadorEliminarVehiculo = manejadorEliminarVehiculo;
        this.manejadorActualizarVehiculo = manejadorActualizarVehiculo;
    }


    @PostMapping
    @ApiOperation("Crear Vehiculo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVehiculo comandoVehiculo) {
        return manejadorCrearVehiculo.ejecutar(comandoVehiculo);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Vehiculo")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarVehiculo.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Vehiculo")
    public void actualizar(@RequestBody ComandoVehiculo comandoVehiculo,@PathVariable Long id) {
        comandoVehiculo.setId(id);
        manejadorActualizarVehiculo.ejecutar(comandoVehiculo);
    }
}
