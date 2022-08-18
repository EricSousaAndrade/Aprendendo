package com.example.aprendendo.model.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class EnderecoRetornaPessoasDto {

    private Long idEndereco;

    private String logradouro;

    private Long cep;

    private Long numero;

    private Set<PessoaEnderecoDto> pessoaEntities;
}
