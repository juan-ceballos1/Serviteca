package com.ceiba.asistencia.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.comando.manejador.ManejadorActualizarAsistencia;
import com.ceiba.asistencia.comando.manejador.ManejadorCrearAsistencia;
import com.ceiba.asistencia.comando.manejador.ManejadorEliminarAsistencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencia")
@Api(tags = { "Controlador comando asistencia"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ComandoControladorAsistencia {

    private final ManejadorCrearAsistencia manejadorCrearAsistencia;
    private final ManejadorEliminarAsistencia manejadorEliminarAsistencia;
    private final ManejadorActualizarAsistencia manejadorActualizarAsistencia;

    @Autowired
    public ComandoControladorAsistencia(ManejadorCrearAsistencia manejadorCrearAsistencia, ManejadorEliminarAsistencia manejadorEliminarAsistencia, ManejadorActualizarAsistencia manejadorActualizarAsistencia) {
        this.manejadorCrearAsistencia = manejadorCrearAsistencia;
        this.manejadorEliminarAsistencia = manejadorEliminarAsistencia;
        this.manejadorActualizarAsistencia = manejadorActualizarAsistencia;
    }

    @PostMapping
    @ApiOperation("Crear Servicio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAsistencia comandoAsistencia) {
        return manejadorCrearAsistencia.ejecutar(comandoAsistencia);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Servicio")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarAsistencia.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Servicio")
    public void actualizar(@RequestBody ComandoAsistencia comandoAsistencia, @PathVariable Long id) {
        comandoAsistencia.setId(id);
        manejadorActualizarAsistencia.ejecutar(comandoAsistencia);
    }
}
