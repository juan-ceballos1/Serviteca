package com.ceiba.asistencia.adaptador.repositorio;

import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAsistenciaH2 implements RepositorioAsistencia {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="asistencia", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="asistencia", value="actualizar")
    private static String sqlActualizar;


    @SqlStatement(namespace="asistencia", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="asistencia", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioAsistenciaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Asistencia asistencia) {
        return this.customNamedParameterJdbcTemplate.crear(asistencia, sqlCrear);
    }

    @Override
    public void actualizar(Asistencia asistencia) {
        this.customNamedParameterJdbcTemplate.actualizar(asistencia, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        try {
            MapSqlParameterSource paramSource = new MapSqlParameterSource();
            paramSource.addValue("id", id);

            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);

        }
        catch (Exception e){
            throw new RuntimeException("Problema en la operación." ,e);
        }
    }
}
