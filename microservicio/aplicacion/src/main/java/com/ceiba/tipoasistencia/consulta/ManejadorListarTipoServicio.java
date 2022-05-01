package com.ceiba.tipoasistencia.consulta;

import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoAsistencia;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarTipoServicio {
    private final DaoTipoAsistencia daoTipoAsistencia;

    public ManejadorListarTipoServicio(DaoTipoAsistencia daoTipoAsistencia){
        this.daoTipoAsistencia = daoTipoAsistencia;
    }

    public List<DtoTipoAsistencia> ejecutar(){ return this.daoTipoAsistencia.listar(); }
}
