package br.com.fiap.netxai.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "clientes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    
    @Id
    private String id; // Mude o tipo de Long para String para o MongoDB
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String genero;
    private LocalDate dt_nascimento;
    private String telefone;
    private int pontos;
    private String fidelidade;
}

