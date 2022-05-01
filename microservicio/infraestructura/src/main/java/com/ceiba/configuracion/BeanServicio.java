package com.ceiba.configuracion;

import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.asistencia.servicio.ServicioActualizarAsistencia;
import com.ceiba.asistencia.servicio.ServicioCrearAsistencia;
import com.ceiba.asistencia.servicio.ServicioEliminarAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoAsistencia;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioActualizarTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioCrearTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.ServicioEliminarTipoAsistencia;
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
    public ServicioCrearTipoAsistencia servicioCrearTipoServicio(RepositorioTipoAsistencia repositorioTipoAsistencia) {
        return new ServicioCrearTipoAsistencia(repositorioTipoAsistencia);
    }

    @Bean
    public ServicioEliminarTipoAsistencia servicioEliminarTipoServicio(RepositorioTipoAsistencia repositorioTipoAsistencia) {
        return new ServicioEliminarTipoAsistencia(repositorioTipoAsistencia);
    }

    @Bean
    public ServicioActualizarTipoAsistencia servicioActualizarTipoServicio(RepositorioTipoAsistencia repositorioTipoAsistencia) {
        return new ServicioActualizarTipoAsistencia(repositorioTipoAsistencia);
    }

    @Bean
    public ServicioCrearAsistencia servicioCrearServicio(RepositorioAsistencia repositorioAsistencia, DaoTipoAsistencia daoTipoAsistencia, RepositorioTipoAsistencia repositorioTipoAsistencia) {
        return new ServicioCrearAsistencia(repositorioAsistencia, daoTipoAsistencia, repositorioTipoAsistencia);
    }

    @Bean
    public ServicioEliminarAsistencia servicioEliminarServicio(RepositorioAsistencia repositorioAsistencia) {
        return new ServicioEliminarAsistencia(repositorioAsistencia);
    }

    @Bean
    public ServicioActualizarAsistencia servicioActualizarServicio(RepositorioAsistencia repositorioAsistencia) {
        return new ServicioActualizarAsistencia(repositorioAsistencia);
    }

}
