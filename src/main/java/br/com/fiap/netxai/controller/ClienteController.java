package br.com.fiap.netxai.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.netxai.model.Cliente;
import br.com.fiap.netxai.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("clientes")
@Slf4j
public class ClienteController {
    
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> index() {
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        log.info("Cadastrando cliente: {}", cliente);
        Cliente savedCliente = clienteRepository.save(cliente);
        return ResponseEntity.status(CREATED).body(savedCliente);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> get(@PathVariable String id) { 
        log.info("Buscando por id: {}", id);
        return clienteRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable String id, @RequestBody Cliente cliente) {
        log.info("Atualizando cliente id {} para {}", id, cliente);
        verificarSeExisteCliente(id);
        cliente.setId(id); // Definindo o ID do cliente
        Cliente updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable String id) {
        log.info("Apagando cliente {}", id);
        verificarSeExisteCliente(id);
        clienteRepository.deleteById(id);
    }

    private void verificarSeExisteCliente(String id) {
        clienteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

}
