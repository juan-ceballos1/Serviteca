package com.ceiba.tipoasistencia.consulta;

import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoServicio;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarTipoServicio {
    private final DaoTipoServicio daoTipoServicio;

    public ManejadorListarTipoServicio(DaoTipoServicio daoTipoServicio){
        this.daoTipoServicio = daoTipoServicio;
    }

    public List<DtoTipoAsistencia> ejecutar(){ return this.daoTipoServicio.listar(); }
}
