package com.ceiba.tipoasistencia.controlador;

import com.ceiba.tipoasistencia.consulta.ManejadorListarTipoServicio;
import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoasistencia")
@Api(tags={"Controlador consulta tipoAsistencia"})
public class ConsultaControladorTipoAsistencia {
    private final ManejadorListarTipoServicio manejadorListarTipoServicio;

    public ConsultaControladorTipoAsistencia(ManejadorListarTipoServicio manejadorListarTipoServicio) {
        this.manejadorListarTipoServicio = manejadorListarTipoServicio;
    }

    @GetMapping
    @ApiOperation("Listar TipoAsistencia")
    public List<DtoTipoAsistencia> listar() {
        return this.manejadorListarTipoServicio.ejecutar();
    }
}
