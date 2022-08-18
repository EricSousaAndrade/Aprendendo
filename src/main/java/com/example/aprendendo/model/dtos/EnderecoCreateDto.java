package com.example.aprendendo.model.dtos;

import lombok.Data;

@Data
public class EnderecoCreateDto {

    private String logradouro;

    private Long cep;

    private Long numero;
}
