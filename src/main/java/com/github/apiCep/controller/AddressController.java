package com.github.apiCep.controller;

import com.github.apiCep.dto.AddressResponseDto;
import com.github.apiCep.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private  final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping("/{cep}")
    public AddressResponseDto getAddressByCep(@PathVariable String cep) {
        return service.getAddressByCep(cep);
    }

}
