package br.com.fiap.netxai.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.netxai.model.Cliente;
import br.com.fiap.netxai.model.Produto;
import br.com.fiap.netxai.repository.ClienteRepository;
import br.com.fiap.netxai.repository.ProdutoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        clienteRepository.deleteAll();
        produtoRepository.deleteAll();

        // Inserindo Clientes
        clienteRepository.saveAll(
            List.of(
                Cliente.builder().id(null)
                    .nome("joao")
                    .cpf("32456768515")
                    .email("joao@gmail.com")
                    .senha("123")
                    .genero("masculino")
                    .dt_nascimento(LocalDate.parse("2024-04-12"))
                    .telefone("12345678945876")
                    .pontos(0)
                    .fidelidade("NÃOFILIADO")
                    .build(),
                Cliente.builder().id(null)
                    .nome("gabi")
                    .cpf("12345678528")
                    .email("gabi@gmail.com")
                    .senha("456")
                    .genero("feminino")
                    .dt_nascimento(LocalDate.parse("2023-04-09"))
                    .telefone("65894236587526")
                    .pontos(1)
                    .fidelidade("FILIADO")
                    .build(),
                Cliente.builder().id(null)
                    .nome("pedro")
                    .cpf("23456789496")
                    .email("pedro@gmail.com")
                    .senha("789")
                    .genero("masculino")
                    .dt_nascimento(LocalDate.parse("2015-03-24"))
                    .telefone("11986575235489")
                    .pontos(556)
                    .fidelidade("FILIADO")
                    .build(),
                Cliente.builder().id(null)
                    .nome("otavio")
                    .cpf("33445566378")
                    .email("otavio@gmail.com")
                    .senha("2233")
                    .genero("masculino")
                    .dt_nascimento(LocalDate.parse("2024-09-02"))
                    .telefone("22486597621478")
                    .pontos(3)
                    .fidelidade("FILIADO")
                    .build(),
                Cliente.builder().id(null)
                    .nome("giovanna")
                    .cpf("97554566378")
                    .email("giovanna@gmail.com")
                    .senha("1245")
                    .genero("feminino")
                    .dt_nascimento(LocalDate.parse("2023-05-12"))
                    .telefone("22894397621478")
                    .pontos(27)
                    .fidelidade("FILIADO")
                    .build()
            ));

        // Inserindo Produtos
        produtoRepository.saveAll(
            List.of(
                Produto.builder().id(null)
                    .nome("sabão")
                    .categoria("limpeza")
                    .valor(98.5f)
                    .estoque(100f) // Novo campo
                    .dt_venci("2025-01-01") // Novo campo
                    .dt_fabrica("2024-01-01") // Novo campo
                    .marca("Marca A") // Novo campo
                    .unidadeMedida("kg") // Novo campo
                    .peso_volume(1.0f) // Novo campo
                    .build(),
                Produto.builder().id(null)
                    .nome("pão")
                    .categoria("padaria")
                    .valor(4.20f)
                    .estoque(200f) // Novo campo
                    .dt_venci("2024-12-31") // Novo campo
                    .dt_fabrica("2024-11-01") // Novo campo
                    .marca("Marca B") // Novo campo
                    .unidadeMedida("kg") // Novo campo
                    .peso_volume(0.5f) // Novo campo
                    .build(),
                Produto.builder().id(null)
                    .nome("salame")
                    .categoria("frios")
                    .valor(32.5f)
                    .estoque(150f) // Novo campo
                    .dt_venci("2025-02-15") // Novo campo
                    .dt_fabrica("2024-02-10") // Novo campo
                    .marca("Marca C") // Novo campo
                    .unidadeMedida("kg") // Novo campo
                    .peso_volume(0.25f) // Novo campo
                    .build(),
                Produto.builder().id(null)
                    .nome("sereal")
                    .categoria("sereal")
                    .valor(67.32f)
                    .estoque(80f) // Novo campo
                    .dt_venci("2025-05-20") // Novo campo
                    .dt_fabrica("2024-03-15") // Novo campo
                    .marca("Marca D") // Novo campo
                    .unidadeMedida("kg") // Novo campo
                    .peso_volume(0.75f) // Novo campo
                    .build(),
                Produto.builder().id(null)
                    .nome("água")
                    .categoria("bebida")
                    .valor(2.00f)
                    .estoque(300f) // Novo campo
                    .dt_venci("2025-01-01") // Novo campo
                    .dt_fabrica("2024-10-01") // Novo campo
                    .marca("Marca E") // Novo campo
                    .unidadeMedida("litro") // Novo campo
                    .peso_volume(1.0f) // Novo campo
                    .build()
            ));
    }
}
