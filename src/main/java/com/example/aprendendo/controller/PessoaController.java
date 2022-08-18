package com.example.aprendendo.controller;


import com.example.aprendendo.model.dtos.PessoaCreateDto;
import com.example.aprendendo.model.dtos.PessoaDto;
import com.example.aprendendo.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<PessoaDto> criarPessoa(@RequestBody PessoaCreateDto pessoaCreateDto){
        return new ResponseEntity<>(pessoaService.criarPessoa(pessoaCreateDto), HttpStatus.CREATED);
    }

}
