package com.ceiba.servicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import com.ceiba.servicio.puerto.dao.DaoServicio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoServicioH2 implements DaoServicio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="servicio", value="listar")
    private static String sqlListar;

    public DaoServicioH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public List<DtoServicio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoServicio());

    }
}
