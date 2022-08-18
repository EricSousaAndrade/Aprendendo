package com.example.aprendendo.model.dtos;

import lombok.Data;

@Data
public class PessoaCreateDto {

    private String nome;

    private Integer idade;

    private EnderecoCreateDto enderecoEntity;

}
