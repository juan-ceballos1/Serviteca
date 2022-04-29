package com.ceiba.tipoasistencia.comando.fabrica;

import com.ceiba.tipoasistencia.comando.ComandoTipoAsistencia;
import com.ceiba.tipoasistencia.modelo.entidad.TipoAsistencia;
import org.springframework.stereotype.Component;

@Component
public class FabricaTipoServicio {

    public TipoAsistencia crear(ComandoTipoAsistencia comandoTipoAsistencia) {
        return new TipoAsistencia(
                comandoTipoAsistencia.getId(),
                comandoTipoAsistencia.getNombre()
        );
    }
}
