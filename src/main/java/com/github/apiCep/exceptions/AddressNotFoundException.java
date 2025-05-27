package com.github.apiCep.exceptions;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException() {
        super("Cep não encontrado.");
    }

    public AddressNotFoundException(String cep) {
        super("Cep: " + cep + " não encontrado ou Inválido");
    }

    public AddressNotFoundException(String uf, String cidade, String bairro) {
        super("Endereço inválido.");
    }


}
