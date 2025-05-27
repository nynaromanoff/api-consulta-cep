package com.github.apiCep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
public class LogConsultaCep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String returnApi;
    private LocalDateTime dataConsulta;

    public LogConsultaCep(String cep, String returnApi, LocalDateTime dataConsulta) {
        this.cep = cep;
        this.returnApi = returnApi;
        this.dataConsulta = dataConsulta;
    }

}
