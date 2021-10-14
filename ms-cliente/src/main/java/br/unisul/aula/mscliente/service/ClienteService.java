package br.unisul.aula.mscliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.aula.mscliente.client.EnderecoCliente;
import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.EnderecoDTO;
import br.unisul.aula.mscliente.mappers.ClienteMapper;
import br.unisul.aula.mscliente.modelo.Cliente;
import br.unisul.aula.mscliente.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoCliente enderecoCliente;
	
	public List<ClienteDTO> listClientes() {
		return ClienteMapper.clientesToClientesDTO((List<Cliente>)clienteRepository.findAll());
	}
	
	public ClienteDTO createCliente(ClienteDTO clienteDTO) {
		EnderecoDTO endereco = enderecoCliente.addEndereco(clienteDTO.getEndereco());
		Cliente newCliente = clienteRepository.save(ClienteMapper.clienteDTOToCliente(clienteDTO));
		return ClienteMapper.clienteEnderecoToClienteDTO(newCliente, endereco);
	}
}
