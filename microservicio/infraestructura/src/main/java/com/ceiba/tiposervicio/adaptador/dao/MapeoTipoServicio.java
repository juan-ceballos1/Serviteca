package com.ceiba.tiposervicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTipoServicio implements RowMapper<DtoTipoServicio>, MapperResult {

    @Override
    public DtoTipoServicio mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");

        return new DtoTipoServicio(id,nombre);
    }

}