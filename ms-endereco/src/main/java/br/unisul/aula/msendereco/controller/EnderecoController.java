package br.unisul.aula.msendereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import br.unisul.aula.msendereco.dto.EnderecoDTO;
import br.unisul.aula.msendereco.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

  @Autowired
  EnderecoService enderecoService;

  @GetMapping
  @RequestMapping()
  public ResponseEntity<List<EnderecoDTO>> getEnderecos(@RequestParam(required = false) Integer cep) {
    List<EnderecoDTO> enderecosDTO = enderecoService.listEnderecos(cep);
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
    EnderecoDTO newEnderecoDTO = enderecoService.createEndereco(enderecoDTO);
    return ResponseEntity.status(HttpStatus.OK).body(newEnderecoDTO);
  }

}