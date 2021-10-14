package br.unisul.aula.msendereco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.unisul.aula.msendereco.modelo.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

  @Query("SELECT e FROM Endereco e WHERE e.cep LIKE CONCAT('%',:cep,'%')")
  List<Endereco> findByCep(Integer cep);
}