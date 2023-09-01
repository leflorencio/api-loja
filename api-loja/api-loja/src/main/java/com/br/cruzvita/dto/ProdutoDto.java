package com.br.cruzvita.dto;

import com.br.cruzvita.model.CategoriaModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @Positive(message = "O preço do produto deve ser um valor positivo")
    private Double preco;

    @PositiveOrZero(message = "A quantidade em estoque do produto deve ser um valor positivo ou zero")
    private Integer quantidadeEstoque;

    private CategoriaModel categoria;
}
