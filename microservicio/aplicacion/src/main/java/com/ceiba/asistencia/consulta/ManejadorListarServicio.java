package com.ceiba.asistencia.consulta;

import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import com.ceiba.asistencia.puerto.dao.DaoAsistencia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarServicio {
    private final DaoAsistencia daoAsistencia;

    public ManejadorListarServicio(DaoAsistencia daoAsistencia){
        this.daoAsistencia = daoAsistencia;
    }

    public List<DtoAsistencia> ejecutar(){ return this.daoAsistencia.listar(); }
}
