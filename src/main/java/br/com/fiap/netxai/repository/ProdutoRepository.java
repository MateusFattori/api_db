package br.com.fiap.netxai.repository;

import br.com.fiap.netxai.model.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
}

