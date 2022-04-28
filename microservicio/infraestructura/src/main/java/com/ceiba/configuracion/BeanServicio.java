package com.ceiba.configuracion;

import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.ServicioActualizarServicio;
import com.ceiba.servicio.servicio.ServicioCrearServicio;
import com.ceiba.servicio.servicio.ServicioEliminarServicio;
import com.ceiba.tiposervicio.puerto.dao.DaoTipoServicio;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;
import com.ceiba.tiposervicio.servicio.ServicioActualizarTipoServicio;
import com.ceiba.tiposervicio.servicio.ServicioCrearTipoServicio;
import com.ceiba.tiposervicio.servicio.ServicioEliminarTipoServicio;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioActualizarVehiculo;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import com.ceiba.vehiculo.servicio.ServicioEliminarVehiculo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo){
        return new ServicioCrearVehiculo(repositorioVehiculo);
    }
    @Bean
    public ServicioEliminarVehiculo servicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        return new ServicioEliminarVehiculo(repositorioVehiculo);
    }

    @Bean
    public ServicioActualizarVehiculo servicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        return new ServicioActualizarVehiculo(repositorioVehiculo);
    }

    @Bean
    public ServicioCrearTipoServicio servicioCrearTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        return new ServicioCrearTipoServicio(repositorioTipoServicio);
    }

    @Bean
    public ServicioEliminarTipoServicio servicioEliminarTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        return new ServicioEliminarTipoServicio(repositorioTipoServicio);
    }

    @Bean
    public ServicioActualizarTipoServicio servicioActualizarTipoServicio(RepositorioTipoServicio repositorioTipoServicio) {
        return new ServicioActualizarTipoServicio(repositorioTipoServicio);
    }

    @Bean
    public ServicioCrearServicio servicioCrearServicio(RepositorioServicio repositorioServicio, DaoTipoServicio daoTipoServicio, RepositorioTipoServicio repositorioTipoServicio) {
        return new ServicioCrearServicio(repositorioServicio, daoTipoServicio, repositorioTipoServicio);
    }

    @Bean
    public ServicioEliminarServicio servicioEliminarServicio(RepositorioServicio repositorioServicio) {
        return new ServicioEliminarServicio(repositorioServicio);
    }

    @Bean
    public ServicioActualizarServicio servicioActualizarServicio(RepositorioServicio repositorioServicio) {
        return new ServicioActualizarServicio(repositorioServicio);
    }

}
