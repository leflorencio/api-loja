package com.br.cruzvita.service;

import com.br.cruzvita.dto.CategoriaDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoriaService {

    ResponseEntity<Object> cadastrar(CategoriaDto categoria);

    ResponseEntity<?> listarTodos(Pageable pageable);

    ResponseEntity<?> listarPorId(Long id);

    ResponseEntity<Object> deletar(Long id);

    ResponseEntity<Object> atualizar(Long id, CategoriaDto categoria);
}
