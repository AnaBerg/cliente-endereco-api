package br.unisul.aula.mscliente.mappers;

import java.util.ArrayList;
import java.util.List;

import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.EnderecoDTO;
import br.unisul.aula.mscliente.modelo.Cliente;

public class ClienteMapper {

	public static Cliente clienteDTOToCliente(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(),clienteDTO.getNome(), clienteDTO.getEndereco().getId(), clienteDTO.getComplemento(), clienteDTO.getNumero());
	}
	
	public static ClienteDTO clienteToClienteDTO(Cliente cliente) {
		return new ClienteDTO(cliente.getId(),cliente.getNome(), cliente.getEndereco_id(), cliente.getComplemento(), cliente.getNumero());
	}
	
	public static List<ClienteDTO> clientesToClientesDTO(List<Cliente> clientes) {
		List<ClienteDTO> clientesDTO = new ArrayList<>();
		clientes.forEach(cliente -> clientesDTO.add(clienteToClienteDTO(cliente)));
		
		return clientesDTO;
	}
	
	public static ClienteDTO clienteEnderecoToClienteDTO(Cliente cliente, EnderecoDTO enderecoDTO) {
		ClienteDTO clienteDTO = ClienteMapper.clienteToClienteDTO(cliente);
		clienteDTO.setEndereco(enderecoDTO);
		return clienteDTO;
	}
}
