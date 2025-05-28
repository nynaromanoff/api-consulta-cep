package com.github.apiCep.exceptions;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(String cep) {
        super("Cep: " + cep + " não encontrado ou Inválido");
    }


}
