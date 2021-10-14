package br.unisul.aula.msendereco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.aula.msendereco.dto.EnderecoDTO;
import br.unisul.aula.msendereco.mappers.EnderecoMapper;
import br.unisul.aula.msendereco.modelo.Endereco;
import br.unisul.aula.msendereco.repository.EnderecoRepository;

@Service
public class EnderecoService {

  @Autowired
  EnderecoRepository enderecoRepository;

  public List<EnderecoDTO> listEnderecos(Integer cep) {

    List<Endereco> enderecos = cep != null ? enderecoRepository.findByCep(cep)
        : (List<Endereco>) enderecoRepository.findAll();

    return EnderecoMapper.enderecosToEnderecosDTO(enderecos);
  }

  public EnderecoDTO createEndereco(EnderecoDTO enderecoDTO) {
    Endereco newEndereco = enderecoRepository.save(EnderecoMapper.enderecoDTOToEndereco(enderecoDTO));
    return EnderecoMapper.enderecoToEnderecoDTO(newEndereco);
  }

}