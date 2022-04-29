package com.ceiba.configuracion;

import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.asistencia.servicio.ServicioActualizarAsistencia;
import com.ceiba.asistencia.servicio.ServicioCrearAsistencia;
import com.ceiba.asistencia.servicio.ServicioEliminarAsistencia;
import com.ceiba.tipoasistencia.puerto.dao.DaoTipoServicio;
import com.ceiba.tipoasistencia.puerto.repositorio.RepositorioTipoServicio;
import com.ceiba.tipoasistencia.servicio.ServicioActualizarTipoServicio;
import com.ceiba.tipoasistencia.servicio.ServicioCrearTipoServicio;
import com.ceiba.tipoasistencia.servicio.ServicioEliminarTipoServicio;
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
    public ServicioCrearAsistencia servicioCrearServicio(RepositorioAsistencia repositorioAsistencia, DaoTipoServicio daoTipoServicio, RepositorioTipoServicio repositorioTipoServicio) {
        return new ServicioCrearAsistencia(repositorioAsistencia, daoTipoServicio, repositorioTipoServicio);
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
