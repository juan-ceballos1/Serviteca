package com.ceiba.tipoasistencia.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tipoasistencia.comando.ComandoTipoAsistencia;
import com.ceiba.tipoasistencia.servicio.testdatabuilder.ComandoTipoAsistenciaTestDataBuilder;
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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorTipoAsistencia.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorTipoAsistenciaTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un tipoAsistencia")
    void deberiaCrearUnTipoAsistencia() throws Exception{
        // arrange
        ComandoTipoAsistencia comandoTipoAsistencia = new ComandoTipoAsistenciaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/tipoasistencia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoTipoAsistencia)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar un tipoAsistencia")
    void deberiaActualizarTipoAsistencia() throws Exception{
        // arrange
        Long id = 1L;
        ComandoTipoAsistencia comandoTipoAsistencia = new ComandoTipoAsistenciaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/tipoasistencia/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoTipoAsistencia)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un tipoAsistencia")
    void deberiaEliminarTipoAsistencia() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/tipoasistencia/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/tipoasistencia")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}
