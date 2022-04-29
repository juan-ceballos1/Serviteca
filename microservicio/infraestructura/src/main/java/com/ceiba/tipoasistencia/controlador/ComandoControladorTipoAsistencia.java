package com.ceiba.tipoasistencia.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tipoasistencia.comando.ComandoTipoAsistencia;
import com.ceiba.tipoasistencia.comando.manejador.ManejadorActualizarTipoServicio;
import com.ceiba.tipoasistencia.comando.manejador.ManejadorCrearTipoServicio;
import com.ceiba.tipoasistencia.comando.manejador.ManejadorEliminarTipoServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoasistencia")
@Api(tags = { "Controlador comando tipoAsistencia"})
public class ComandoControladorTipoAsistencia {
    private final ManejadorCrearTipoServicio manejadorCrearTipoServicio;
    private final ManejadorEliminarTipoServicio manejadorEliminarTipoServicio;
    private final ManejadorActualizarTipoServicio manejadorActualizarTipoServicio;

    @Autowired
    public ComandoControladorTipoAsistencia(ManejadorCrearTipoServicio manejadorCrearTipoServicio, ManejadorEliminarTipoServicio manejadorEliminarTipoServicio, ManejadorActualizarTipoServicio manejadorActualizarTipoServicio) {
        this.manejadorCrearTipoServicio = manejadorCrearTipoServicio;
        this.manejadorEliminarTipoServicio = manejadorEliminarTipoServicio;
        this.manejadorActualizarTipoServicio = manejadorActualizarTipoServicio;
    }

    @PostMapping
    @ApiOperation("Crear TipoAsistencia")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTipoAsistencia comandoTipoAsistencia) {
        return manejadorCrearTipoServicio.ejecutar(comandoTipoAsistencia);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar TipoAsistencia")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarTipoServicio.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar TipoAsistencia")
    public void actualizar(@RequestBody ComandoTipoAsistencia comandoTipoAsistencia, @PathVariable Long id) {
        comandoTipoAsistencia.setId(id);
        manejadorActualizarTipoServicio.ejecutar(comandoTipoAsistencia);
    }
}
