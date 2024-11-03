package br.com.fiap.netxai.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "produtos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    
    @Id
    private String id; 
    private String nome;
    private String categoria;
    private Float valor;
    private Float estoque;
    private String dt_venci;
    private String dt_fabrica;
    private String marca;
    private String unidadeMedida;
    private Float peso_volume;
}
