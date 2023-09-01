package com.br.cruzvita.controller;

import com.br.cruzvita.dto.ProdutoDto;
import com.br.cruzvita.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody ProdutoDto produto) {
        return produtoService.cadastrar(produto);
    }
}
