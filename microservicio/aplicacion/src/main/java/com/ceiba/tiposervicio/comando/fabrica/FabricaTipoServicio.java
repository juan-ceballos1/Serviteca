package com.ceiba.tiposervicio.comando.fabrica;

import com.ceiba.tiposervicio.comando.ComandoTipoServicio;
import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import org.springframework.stereotype.Component;

@Component
public class FabricaTipoServicio {

    public TipoServicio crear(ComandoTipoServicio comandoTipoServicio) {
        return new TipoServicio(
                comandoTipoServicio.getId(),
                comandoTipoServicio.getNombre()
        );
    }
}
