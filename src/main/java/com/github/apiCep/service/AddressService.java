package com.github.apiCep.service;

import com.github.apiCep.model.AddressResponseDto;

import org.springframework.stereotype.Service;

@Service
public interface AddressService {
  AddressResponseDto getAddressByCep(String cep);
}
