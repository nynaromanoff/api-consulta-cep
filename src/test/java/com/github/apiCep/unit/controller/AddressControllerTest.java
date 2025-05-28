package com.github.apiCep.unit.controller;


import com.github.apiCep.dto.AddressResponseDto;
import com.github.apiCep.entity.LogConsultaCep;
import com.github.apiCep.repository.AddressRepository;
import com.github.apiCep.service.AddressService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddressService service;

    @MockitoBean
    private AddressRepository repository;


    @Test
    void shouldReturnValidCep() throws Exception {
        AddressResponseDto mockResponse = new AddressResponseDto();
        mockResponse.setCep("01001-000");

        when(service.getAddressByCep(anyString())).thenReturn(mockResponse);

        mockMvc.perform(get("/address/01001000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cep").value("01001-000"));
    }

    @Test
    void shouldReturnListLogs() throws Exception {
        when(repository.findAll()).thenReturn(
                Collections.singletonList(
                        buildCepLogEntity()
                )
        );

        mockMvc.perform(get("/address/logs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cep").value("01001-000"))
                .andExpect(jsonPath("$[0].consultaEm").exists());
    }

    private LogConsultaCep buildCepLogEntity() {
        LogConsultaCep entity = new LogConsultaCep();
        entity.setCep("01001-000");
        entity.setDataConsulta(LocalDateTime.now());
        entity.setReturnApi("{\"mock\":true}");
        return entity;
    }

    @TestConfiguration
    static class MockConfig {

        @Bean
        @Primary
        public AddressService addressService() {
            return Mockito.mock(AddressService.class);
        }
    }
}
