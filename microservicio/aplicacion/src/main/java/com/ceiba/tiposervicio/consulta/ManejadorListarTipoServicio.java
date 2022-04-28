package com.ceiba.tiposervicio.consulta;

import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import com.ceiba.tiposervicio.puerto.dao.DaoTipoServicio;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarTipoServicio {
    private final DaoTipoServicio daoTipoServicio;

    public ManejadorListarTipoServicio(DaoTipoServicio daoTipoServicio){
        this.daoTipoServicio = daoTipoServicio;
    }

    public List<DtoTipoServicio> ejecutar(){ return this.daoTipoServicio.listar(); }
}
