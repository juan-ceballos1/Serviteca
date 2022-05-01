package com.ceiba.tipoasistencia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoAsistencia;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTipoAsistenciaH2 implements DaoTipoAsistencia {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipoasistencia", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="tipoasistencia", value="listarPorId")
    private static String sqlListarPorId;

    public DaoTipoAsistenciaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTipoAsistencia> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTipoAsistencia());
    }

    @Override
    public DtoTipoAsistencia consultarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlListarPorId,paramSource, new MapeoTipoAsistencia());
    }
}
