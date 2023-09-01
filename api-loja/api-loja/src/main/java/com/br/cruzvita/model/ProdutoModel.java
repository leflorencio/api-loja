package com.br.cruzvita.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 250)
    private String descricao;

    @Column(nullable = false, length = 50)
    private Double preco;

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private CategoriaModel categoria;
}
