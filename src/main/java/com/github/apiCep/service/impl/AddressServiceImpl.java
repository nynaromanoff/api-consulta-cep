package com.github.apiCep.service.impl;

import com.github.apiCep.client.CepClient;
import com.github.apiCep.entity.LogConsultaCep;
import com.github.apiCep.exceptions.AddressBadRequestException;
import com.github.apiCep.exceptions.AddressNotFoundException;
import com.github.apiCep.mapper.CepLogMapper;
import com.github.apiCep.dto.AddressResponseDto;
import com.github.apiCep.repository.AddressRepository;
import com.github.apiCep.service.AddressService;
import feign.FeignException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
public class AddressServiceImpl implements AddressService {
    private final CepClient clientCep;

    private final AddressRepository repository;

    public AddressServiceImpl(CepClient clientCep, AddressRepository repository) {
        this.clientCep = clientCep;
        this.repository = repository;
    }

    @Override
    public AddressResponseDto getAddressByCep(String cep) {
        try {
            AddressResponseDto dto = clientCep.getAddressByCep(cep);
            LogConsultaCep log = CepLogMapper.fromCepResponse(cep, dto);
            repository.save(log);

            if(ObjectUtils.isEmpty(dto) || dto.getCep() == null) {
                throw new AddressNotFoundException(cep);
            }

            return dto;

        } catch (FeignException.NotFound e) {
            throw new AddressBadRequestException(cep);
        }
    }
}
