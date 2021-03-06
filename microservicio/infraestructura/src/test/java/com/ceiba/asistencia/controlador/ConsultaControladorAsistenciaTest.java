package com.ceiba.asistencia.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tipoasistencia.controlador.ConsultaControladorTipoAsistencia;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.ComandoVehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorAsistencia.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorAsistenciaTest {
    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar asistencia")
    void deberiaListarTipoServicio() throws Exception {
        // arrange
        ComandoVehiculo vehiculo= new ComandoVehiculoTestDataBuilder().conId(1L).conMatricula("12345").conMarca("NISSAN").conModelo("CENTRA").build();
        // act - assert
        mocMvc.perform(get("/asistencia")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].vehiculo.id", is(1)))
                .andExpect(jsonPath("$[0].fechaInicio", is("2022-05-03 18:15:56")))
                .andExpect(jsonPath("$[0].fechaFin", is("2022-05-03 18:15:56")))
                .andExpect(jsonPath("$[0].precio", is(2000.0)))
                .andExpect(jsonPath("$[0].id", is(1)));

    }
}
