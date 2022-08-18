package com.example.aprendendo.controller;

import com.example.aprendendo.exceptions.EnderecoNaoEncontradoException;
import com.example.aprendendo.model.dtos.*;
import com.example.aprendendo.model.entities.EnderecoEntity;
import com.example.aprendendo.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping("/adicionar")
    public ResponseEntity<EnderecoDto> salvaEndereco(@RequestBody EnderecoCreateDto enderecoCreateDto){
        return new ResponseEntity<>(enderecoService.adicionarEndereco(enderecoCreateDto), HttpStatus.CREATED);
    }

    @PostMapping("/adicionar-endereco-com-pessoas")
    public ResponseEntity<EnderecoRetornaPessoasDto> salvaEndereco(@RequestBody EnderecoCreatePessoasDto enderecoCreatePessoasDto){
        return new ResponseEntity<>(enderecoService.adicionaEnderecoComPessoas(enderecoCreatePessoasDto), HttpStatus.CREATED);
    }

    @GetMapping("/retorna-endereco")
    public EnderecoEntity buscaEnderecoPorId(@RequestParam Long id) throws EnderecoNaoEncontradoException {
        return enderecoService.buscaEnderecoPorId(id);
    }

}
