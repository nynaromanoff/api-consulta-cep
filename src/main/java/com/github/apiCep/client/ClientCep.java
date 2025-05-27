package com.github.apiCep.client;

import com.github.apiCep.model.AddressResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep" , url = "https://viacep.com.br/ws")
public interface ClientCep {
    @GetMapping("/{cep}/json")
    AddressResponseDto getAddressByCep(@PathVariable("cep") String cep);
}

