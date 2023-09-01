package com.br.cruzvita.service;

import com.br.cruzvita.dto.ProdutoDto;
import com.br.cruzvita.model.ProdutoModel;
import com.br.cruzvita.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Override
    public ResponseEntity<Object> cadastrar(ProdutoDto produto) {
        try {
            ProdutoModel produtoModel = new ProdutoModel();
            if (repository.existsByNome(produto.getNome())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("O produto já está cadastrado");
            } else {
                produtoModel.setNome(produto.getNome());
                produtoModel.setDescricao(produto.getDescricao());
                produtoModel.setPreco(produto.getPreco());
                produtoModel.setQuantidadeEstoque(produto.getQuantidadeEstoque());
                produtoModel.setCategoria(produto.getCategoria());
                repository.save(produtoModel);

                return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
