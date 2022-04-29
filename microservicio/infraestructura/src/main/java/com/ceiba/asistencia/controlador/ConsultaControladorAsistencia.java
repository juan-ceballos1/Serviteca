package com.ceiba.asistencia.controlador;

import com.ceiba.asistencia.consulta.ManejadorListarServicio;
import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asistencia")
@Api(tags={"Controlador consulta Asistencia"})
public class ConsultaControladorAsistencia {
    private final ManejadorListarServicio manejadorListarServicio;

    public ConsultaControladorAsistencia(ManejadorListarServicio manejadorListarServicio) {
        this.manejadorListarServicio = manejadorListarServicio;
    }

    @GetMapping
    @ApiOperation("Listar Servicio")
    public List<DtoAsistencia> listar() {
        return this.manejadorListarServicio.ejecutar();
    }
}
