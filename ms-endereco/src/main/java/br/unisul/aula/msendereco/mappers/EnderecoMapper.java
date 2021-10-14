package br.unisul.aula.msendereco.mappers;

import java.util.ArrayList;
import java.util.List;

import br.unisul.aula.msendereco.dto.EnderecoDTO;
import br.unisul.aula.msendereco.modelo.Endereco;

public abstract class EnderecoMapper {

  public static Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
    return new Endereco(enderecoDTO.getId(), enderecoDTO.getCep(), enderecoDTO.getLogradouro(), enderecoDTO.getBairro(), enderecoDTO.getCidade(), enderecoDTO.getUf());
  }

  public static EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
    return new EnderecoDTO(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getBairro(),
        endereco.getCidade(), endereco.getUf());
  }

  public static List<EnderecoDTO> enderecosToEnderecosDTO(List<Endereco> enderecos) {
    List<EnderecoDTO> enderecosDTO = new ArrayList<>();
    enderecos.forEach(endereco -> enderecosDTO.add(enderecoToEnderecoDTO(endereco)));

    return enderecosDTO;
  }

}