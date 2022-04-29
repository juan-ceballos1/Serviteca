package com.ceiba.tipoasistencia.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoServicio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTipoAsistenciaH2 implements RepositorioTipoServicio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipoasistencia", value="crear")
    private static String sqlCrearTipoAsistencia;

    @SqlStatement(namespace="tipoasistencia", value="actualizar")
    private static String sqlActualizarTipoAsistencia;

    @SqlStatement(namespace="tipoasistencia", value="eliminar")
    private static String sqlEliminarTipoAsistencia;

    @SqlStatement(namespace="tipoasistencia", value="existe")
    private static String sqlExisteTipoAsistencia;

    @SqlStatement(namespace="tipoasistencia", value="existePorId")
    private static String sqlExistePorIdTipoAsistencia;

    public RepositorioTipoAsistenciaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(TipoAsistencia tipoAsistencia) {
        return this.customNamedParameterJdbcTemplate.crear(tipoAsistencia, sqlCrearTipoAsistencia);
    }

    @Override
    public void actualizar(TipoAsistencia tipoAsistencia) {
        this.customNamedParameterJdbcTemplate.actualizar(tipoAsistencia, sqlActualizarTipoAsistencia);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarTipoAsistencia, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTipoAsistencia,paramSource, Boolean.class);

    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdTipoAsistencia,paramSource, Boolean.class);

    }
}
