package com.br.cruzvita.service;

import com.br.cruzvita.dto.ProdutoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProdutoService {

    ResponseEntity<Object> cadastrar(ProdutoDto produto);
}
