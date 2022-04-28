package com.ceiba.servicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoServicio implements RowMapper<DtoServicio>, MapperResult {

    @Override
    public DtoServicio mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long tipoServicio = resultSet.getLong("id_tipo_servicio");
        Long vehiculo = resultSet.getLong("id_vehiculo");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet,"fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(resultSet,"fecha_fin");
        Double precio = resultSet.getDouble("precio");

        return new DtoServicio(id,tipoServicio,vehiculo,fechaInicio,fechaFin,precio);
    }

}