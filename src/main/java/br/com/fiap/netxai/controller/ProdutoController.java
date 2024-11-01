package br.com.fiap.netxai.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.netxai.model.Produto;
import br.com.fiap.netxai.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("produto")
@Slf4j
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> index() {
        return produtoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        log.info("Cadastrando produto: {}", produto);
        Produto savedProduto = produtoRepository.save(produto);
        return ResponseEntity.status(CREATED).body(savedProduto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> get(@PathVariable String id) { // ID como String
        log.info("Buscando produto por id {}", id);
        return produtoRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable String id) {
        log.info("Apagando produto {}", id);
        verificarSeExisteProduto(id);
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable String id, @RequestBody Produto produto) {
        log.info("Atualizando produto id {} para {}", id, produto);
        verificarSeExisteProduto(id);
        produto.setId(id); // Definindo o ID do produto
        Produto updatedProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    private void verificarSeExisteProduto(String id) {
        produtoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }
}
