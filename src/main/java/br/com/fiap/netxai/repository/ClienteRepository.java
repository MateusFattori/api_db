package br.com.fiap.netxai.repository;

import br.com.fiap.netxai.model.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}

