package com.ceiba.tiposervicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import com.ceiba.tiposervicio.puerto.dao.DaoTipoServicio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTipoServicioH2 implements DaoTipoServicio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tiposervicio", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="tiposervicio", value="listarPorId")
    private static String sqlListarPorId;

    public DaoTipoServicioH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTipoServicio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTipoServicio());
    }

    @Override
    public DtoTipoServicio consultarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlListarPorId,paramSource, new MapeoTipoServicio());
    }
}
