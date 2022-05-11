package com.ceiba.asistencia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoServicio implements RowMapper<DtoAsistencia>, MapperResult {

    @Override
    public DtoAsistencia mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("asistencia.id");
        Long idTipoAsistencia = resultSet.getLong("asistencia.id_tipo_asistencia");
        String nombreTipoAsistencia = resultSet.getString("tipoasistencia.nombre");
        Long idVehiculo = resultSet.getLong("asistencia.id_vehiculo");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet,"asistencia.fecha_inicio");
        LocalDateTime fechaFin = extraerLocalDateTime(resultSet,"asistencia.fecha_fin");
        Double precio = resultSet.getDouble("asistencia.precio");
        String matricula = resultSet.getString("vehiculo.matricula");
        String marca = resultSet.getString("vehiculo.marca");
        String modelo = resultSet.getString("vehiculo.modelo");

        return new DtoAsistencia(id,new DtoTipoAsistencia(idTipoAsistencia,nombreTipoAsistencia),new DtoVehiculo(idVehiculo,matricula,marca,modelo),fechaInicio,fechaFin,precio);
    }

}