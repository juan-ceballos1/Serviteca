package com.ceiba.tipoasistencia.puerto.dao;

import com.ceiba.tipoasistencia.modelo.dto.DtoTipoAsistencia;

import java.util.List;

public interface DaoTipoServicio {
    List<DtoTipoAsistencia> listar();
    DtoTipoAsistencia consultarPorId(Long id);
}
