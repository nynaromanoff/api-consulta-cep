package com.github.apiCep.client;

import com.github.apiCep.dto.AddressResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep" , url = "${client.url}")
public interface CepClient {
    @GetMapping("/{cep}/json")
    AddressResponseDto getAddressByCep(@PathVariable("cep") String cep);
}

