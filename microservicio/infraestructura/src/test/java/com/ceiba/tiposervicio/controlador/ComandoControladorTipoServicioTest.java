package com.ceiba.tiposervicio.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tiposervicio.comando.ComandoTipoServicio;
import com.ceiba.tiposervicio.servicio.testdatabuilder.ComandoTipoServicioTestDataBuilder;
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
@WebMvcTest(ConsultaControladorTipoServicio.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorTipoServicioTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un tipoServicio")
    void deberiaCrearUnTipoServicio() throws Exception{
        // arrange
        ComandoTipoServicio comandoTipoServicio = new ComandoTipoServicioTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/tiposervicio")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoTipoServicio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar un tipoServicio")
    void deberiaActualizarUnUsuario() throws Exception{
        // arrange
        Long id = 2L;
        ComandoTipoServicio comandoTipoServicio = new ComandoTipoServicioTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/tiposervicio/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoTipoServicio)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un tipoServicio")
    void deberiaEliminarUnUsuario() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/tiposervicio/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/tiposervicio")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}
