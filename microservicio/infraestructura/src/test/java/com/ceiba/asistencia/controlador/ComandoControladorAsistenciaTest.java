package com.ceiba.asistencia.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.sevicio.testdatabuilder.ComandoAsistenciaTestDataBuilder;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.controlador.ComandoControladorVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.ComandoVehiculoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorAsistencia.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorAsistenciaTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una asistencia")
    void deberiaCrearUnaAsistencia() throws Exception{
        // arrange
        ComandoAsistencia comandoAsistencia = new ComandoAsistenciaTestDataBuilder().conId(null).conFechaInicio(LocalDateTime.parse("2022-05-03T18:15:56.331372800")).conFechaFin(LocalDateTime.parse("2022-05-03T18:15:56.331372800")).build();
        // act - assert
        mocMvc.perform(post("/asistencia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoAsistencia)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar una asistencia")
    void deberiaActualizarAsistencia() throws Exception{
        // arrange
        Long id = 1L;
        ComandoAsistencia comandoAsistencia = new ComandoAsistenciaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/asistencia/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoAsistencia)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar una asistencia")
    void deberiaEliminarAsistencia() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/asistencia/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/asistencia")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
