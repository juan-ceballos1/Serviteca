package com.ceiba.vehiculo.consulta;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarVehiculos {
    private final DaoVehiculo daoVehiculo;

    public ManejadorListarVehiculos(DaoVehiculo daoVehiculo){
        this.daoVehiculo = daoVehiculo;
    }

    public List<DtoVehiculo> ejecutar(){ return this.daoVehiculo.listar(); }
}
