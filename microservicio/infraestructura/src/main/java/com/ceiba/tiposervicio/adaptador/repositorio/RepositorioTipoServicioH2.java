package com.ceiba.tiposervicio.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTipoServicioH2 implements RepositorioTipoServicio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tiposervicio", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="tiposervicio", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="tiposervicio", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="tiposervicio", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="tiposervicio", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioTipoServicioH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(TipoServicio tipoServicio) {
        return this.customNamedParameterJdbcTemplate.crear(tipoServicio, sqlCrear);
    }

    @Override
    public void actualizar(TipoServicio tipoServicio) {
        this.customNamedParameterJdbcTemplate.actualizar(tipoServicio, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);

    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);

    }
}
