package com.ceiba.servicio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.comando.manejador.ManejadorActualizarServicio;
import com.ceiba.servicio.comando.manejador.ManejadorCrearServicio;
import com.ceiba.servicio.comando.manejador.ManejadorEliminarServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicio")
@Api(tags = { "Controlador comando servicio"})
public class ComandoControladorServicio {

    private final ManejadorCrearServicio manejadorCrearServicio;
    private final ManejadorEliminarServicio manejadorEliminarServicio;
    private final ManejadorActualizarServicio manejadorActualizarServicio;

    @Autowired
    public ComandoControladorServicio(ManejadorCrearServicio manejadorCrearServicio, ManejadorEliminarServicio manejadorEliminarServicio, ManejadorActualizarServicio manejadorActualizarServicio) {
        this.manejadorCrearServicio = manejadorCrearServicio;
        this.manejadorEliminarServicio = manejadorEliminarServicio;
        this.manejadorActualizarServicio = manejadorActualizarServicio;
    }

    @PostMapping
    @ApiOperation("Crear Servicio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoServicio comandoServicio) {
        return manejadorCrearServicio.ejecutar(comandoServicio);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Servicio")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarServicio.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Servicio")
    public void actualizar(@RequestBody ComandoServicio comandoServicio, @PathVariable Long id) {
        comandoServicio.setId(id);
        manejadorActualizarServicio.ejecutar(comandoServicio);
    }
}
