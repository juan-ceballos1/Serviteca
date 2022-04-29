package com.ceiba.tiposervicio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;
import com.ceiba.tiposervicio.servicio.testdatabuilder.TipoServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearTipoServicioTest {
    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del tipoServicio")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelTipoServicio() {
        // arrange
        TipoServicio tipoServicio = new TipoServicioTestDataBuilder().build();
        RepositorioTipoServicio repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        Mockito.when(repositorioTipoServicio.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearTipoServicio servicioCrearTipoServicio = new ServicioCrearTipoServicio(repositorioTipoServicio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearTipoServicio.ejecutar(tipoServicio), ExcepcionDuplicidad.class,"El tipo de servicio ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el tipoServicio de manera correcta")
    void deberiaCrearElTipoServicioDeManeraCorrecta() {
        // arrange
        TipoServicio tipoServicio = new TipoServicioTestDataBuilder().build();
        RepositorioTipoServicio repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        Mockito.when(repositorioTipoServicio.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioTipoServicio.crear(tipoServicio)).thenReturn(10L);
        ServicioCrearTipoServicio servicioCrearTipoServicio = new ServicioCrearTipoServicio(repositorioTipoServicio);
        // act
        Long idTipoServicio = servicioCrearTipoServicio.ejecutar(tipoServicio);
        //- assert
        assertEquals(10L,idTipoServicio);
        Mockito.verify(repositorioTipoServicio, Mockito.times(1)).crear(tipoServicio);
    }
}
