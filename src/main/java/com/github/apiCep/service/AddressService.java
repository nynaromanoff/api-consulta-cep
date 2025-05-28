package com.github.apiCep.service;

import com.github.apiCep.dto.AddressResponseDto;

public interface AddressService {
  AddressResponseDto getAddressByCep(String cep);
}
