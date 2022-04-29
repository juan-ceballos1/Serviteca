package com.ceiba.tipoasistencia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTipoAsistencia implements RowMapper<DtoTipoAsistencia>, MapperResult {

    @Override
    public DtoTipoAsistencia mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");

        return new DtoTipoAsistencia(id,nombre);
    }

}