package br.unisul.aula.mscliente.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unisul.aula.mscliente.dto.EnderecoDTO;

@FeignClient("endereco")
@RequestMapping("enderecos")
public interface EnderecoCliente {

  @RequestMapping(method = RequestMethod.POST)
  EnderecoDTO addEndereco(@RequestBody EnderecoDTO enderecoDTO);

  @RequestMapping("/{enderecoId}")
  EnderecoDTO buscar(@PathVariable Long enderecoId);

}