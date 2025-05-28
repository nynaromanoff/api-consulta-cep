package com.github.apiCep.mapper;

import java.time.LocalDateTime;

public record CepLog(String cep, LocalDateTime consultaEm, String returnApi) { }