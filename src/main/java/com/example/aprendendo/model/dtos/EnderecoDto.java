package com.example.aprendendo.model.dtos;

import lombok.Data;

@Data
public class EnderecoDto {

    private Long idEndereco;

    private String logradouro;

    private Long cep;

    private Long numero;
}
