package com.ceiba.asistencia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoServicio implements RowMapper<DtoAsistencia>, MapperResult {

    @Override
    public DtoAsistencia mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long tipoAsistencia = resultSet.getLong("id_tipo_asistencia");
        Long vehiculo = resultSet.getLong("id_vehiculo");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet,"fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(resultSet,"fecha_fin");
        Double precio = resultSet.getDouble("precio");

        return new DtoAsistencia(id,tipoAsistencia,vehiculo,fechaInicio,fechaFin,precio);
    }

}