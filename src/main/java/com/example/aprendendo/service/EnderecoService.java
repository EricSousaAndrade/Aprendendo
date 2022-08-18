package com.example.aprendendo.service;

import com.example.aprendendo.exceptions.EnderecoNaoEncontradoException;
import com.example.aprendendo.model.dtos.*;
import com.example.aprendendo.model.entities.EnderecoEntity;
import com.example.aprendendo.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final ObjectMapper objectMapper;

    public EnderecoDto adicionarEndereco(EnderecoCreateDto enderecoCreateDto) {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDto, EnderecoEntity.class);
        return objectMapper.convertValue(enderecoRepository.save(enderecoEntity), EnderecoDto.class);
    }

    public EnderecoEntity buscaEnderecoPorId(Long id) throws EnderecoNaoEncontradoException {
        return enderecoRepository.findById(id).orElseThrow(() -> new EnderecoNaoEncontradoException("Não encontramos um endereço com esse ID"));
    }

    public EnderecoRetornaPessoasDto adicionaEnderecoComPessoas(EnderecoCreatePessoasDto enderecoCreatePessoasDto) {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreatePessoasDto, EnderecoEntity.class);
        enderecoEntity.getPessoaEntities().forEach(pessoaEntity -> pessoaEntity.setEnderecoEntity(enderecoEntity));
        return objectMapper.convertValue(enderecoRepository.save(enderecoEntity), EnderecoRetornaPessoasDto.class);
    }

}
