package com.github.apiCep.mapper;

import com.github.apiCep.entity.LogConsultaCep;
import com.github.apiCep.dto.AddressResponseDto;

import java.time.LocalDateTime;

public class CepLogMapper {
    public static LogConsultaCep fromCepResponse(String cep, AddressResponseDto response) {
        LogConsultaCep log = new LogConsultaCep();
        log.setCep(cep);
        log.setReturnApi(response.toString());
        log.setDataConsulta(LocalDateTime.now());
        return log;
    }

    public static CepLog toModel(LogConsultaCep logConsultaCep) {
        return new CepLog(
                logConsultaCep.getCep(),
                logConsultaCep.getDataConsulta(),
                logConsultaCep.getReturnApi()
        );
    }
}
