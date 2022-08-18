package com.example.aprendendo.service;

import com.example.aprendendo.model.dtos.EnderecoDto;
import com.example.aprendendo.model.dtos.PessoaCreateDto;
import com.example.aprendendo.model.dtos.PessoaDto;
import com.example.aprendendo.model.entities.EnderecoEntity;
import com.example.aprendendo.model.entities.PessoaEntity;
import com.example.aprendendo.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final EnderecoService enderecoService;

    private final ObjectMapper objectMapper;

    public PessoaDto criarPessoa(PessoaCreateDto pessoaCreateDto) {
        EnderecoDto enderecoDto = enderecoService.adicionarEndereco(pessoaCreateDto.getEnderecoEntity());
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoDto, EnderecoEntity.class);

        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDto, PessoaEntity.class);
        pessoaEntity.setEnderecoEntity(enderecoEntity);

        PessoaEntity pessoaSalva = pessoaRepository.save(pessoaEntity);
        PessoaDto pessoaDto = objectMapper.convertValue(pessoaSalva, PessoaDto.class);
        pessoaDto.setEnderecoEntity(enderecoDto);

        return pessoaDto;
    }


}
