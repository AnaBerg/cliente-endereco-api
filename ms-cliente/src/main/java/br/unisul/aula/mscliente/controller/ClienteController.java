package br.unisul.aula.mscliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	@RequestMapping()
	public ResponseEntity<List<ClienteDTO>> getClientes() {
		List<ClienteDTO> clientesDTO = clienteService.listClientes();
		return ResponseEntity.status(HttpStatus.OK).body(clientesDTO);
	}
	
	@PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	  public ResponseEntity<ClienteDTO> createEndereco(@RequestBody ClienteDTO clientesDTO) {
		ClienteDTO newClienteDTO = clienteService.createCliente(clientesDTO);
	    return ResponseEntity.status(HttpStatus.OK).body(newClienteDTO);
	  }
}
