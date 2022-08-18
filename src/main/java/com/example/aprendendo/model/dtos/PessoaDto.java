package com.example.aprendendo.model.dtos;

import lombok.Data;

@Data
public class PessoaDto {

    private Long id;

    private String nome;

    private Integer idade;

    private EnderecoDto enderecoEntity;


}
