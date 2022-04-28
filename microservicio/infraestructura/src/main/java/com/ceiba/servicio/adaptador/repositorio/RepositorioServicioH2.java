package com.ceiba.servicio.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioServicioH2 implements RepositorioServicio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="servicio", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="servicio", value="actualizar")
    private static String sqlActualizar;


    @SqlStatement(namespace="servicio", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="servicio", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioServicioH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Servicio servicio) {
        return this.customNamedParameterJdbcTemplate.crear(servicio, sqlCrear);
    }

    @Override
    public void actualizar(Servicio servicio) {
        this.customNamedParameterJdbcTemplate.actualizar(servicio, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);

    }
}
