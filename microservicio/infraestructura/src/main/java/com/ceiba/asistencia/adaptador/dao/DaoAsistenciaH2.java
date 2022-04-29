package com.ceiba.asistencia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import com.ceiba.asistencia.puerto.dao.DaoAsistencia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoAsistenciaH2 implements DaoAsistencia {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="asistencia", value="listar")
    private static String sqlListar;

    public DaoAsistenciaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public List<DtoAsistencia> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoServicio());

    }
}
