package br.unisul.aula.mscliente.repository;

import org.springframework.data.repository.CrudRepository;

import br.unisul.aula.mscliente.modelo.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
