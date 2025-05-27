package com.github.apiCep.exceptions;

public class AddressBadRequestException extends RuntimeException {

    public AddressBadRequestException() {
        super("Cep não encontrado.");
    }

    public AddressBadRequestException(String cep) {
        super("Cep: " + cep + " não encontrado ou Inválido");
    }

    public AddressBadRequestException(String uf, String cidade, String bairro) {
        super("Endereço Inválido.");
    }

}
