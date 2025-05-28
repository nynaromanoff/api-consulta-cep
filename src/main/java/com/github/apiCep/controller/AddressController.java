package com.github.apiCep.controller;

import com.github.apiCep.dto.AddressResponseDto;
import com.github.apiCep.mapper.CepLog;
import com.github.apiCep.mapper.CepLogMapper;
import com.github.apiCep.repository.AddressRepository;
import com.github.apiCep.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    private  final AddressService service;

    private final AddressRepository repository;

    public AddressController(AddressService service, AddressRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/{cep}")
    public AddressResponseDto getAddressByCep(@PathVariable String cep) {
        return service.getAddressByCep(cep);
    }

    @GetMapping("/logs")
    public List<CepLog> listLogs() {
        return repository.findAll().stream()
                .map(CepLogMapper::toModel)
                .collect(Collectors.toList());
    }
}
