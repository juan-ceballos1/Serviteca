package com.ceiba.tiposervicio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tiposervicio.comando.ComandoTipoServicio;
import com.ceiba.tiposervicio.comando.manejador.ManejadorActualizarTipoServicio;
import com.ceiba.tiposervicio.comando.manejador.ManejadorCrearTipoServicio;
import com.ceiba.tiposervicio.comando.manejador.ManejadorEliminarTipoServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tiposervicio")
@Api(tags = { "Controlador comando tipoServicio"})
public class ComandoControladorTipoServicio {
    private final ManejadorCrearTipoServicio manejadorCrearTipoServicio;
    private final ManejadorEliminarTipoServicio manejadorEliminarTipoServicio;
    private final ManejadorActualizarTipoServicio manejadorActualizarTipoServicio;

    @Autowired
    public ComandoControladorTipoServicio(ManejadorCrearTipoServicio manejadorCrearTipoServicio, ManejadorEliminarTipoServicio manejadorEliminarTipoServicio, ManejadorActualizarTipoServicio manejadorActualizarTipoServicio) {
        this.manejadorCrearTipoServicio = manejadorCrearTipoServicio;
        this.manejadorEliminarTipoServicio = manejadorEliminarTipoServicio;
        this.manejadorActualizarTipoServicio = manejadorActualizarTipoServicio;
    }

    @PostMapping
    @ApiOperation("Crear TipoServicio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTipoServicio comandoTipoServicio) {
        return manejadorCrearTipoServicio.ejecutar(comandoTipoServicio);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar TipoServicio")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarTipoServicio.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar TipoServicio")
    public void actualizar(@RequestBody ComandoTipoServicio comandoTipoServicio,@PathVariable Long id) {
        comandoTipoServicio.setId(id);
        manejadorActualizarTipoServicio.ejecutar(comandoTipoServicio);
    }
}
