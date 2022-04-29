package com.ceiba.asistencia.puerto.dao;

import com.ceiba.asistencia.modelo.dto.DtoAsistencia;

import java.util.List;

public interface DaoAsistencia {
    List<DtoAsistencia> listar();
}
