package com.br.cruzvita.controller;

import com.br.cruzvita.dto.CategoriaDto;
import com.br.cruzvita.model.CategoriaModel;
import com.br.cruzvita.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody CategoriaDto categoria) {
        return categoriaService.cadastrar(categoria);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<?> listarTodos(@RequestParam Integer paginas, Integer registros) {
        Pageable pageable = PageRequest.of(paginas - 1, registros);
        return categoriaService.listarTodos(pageable);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable(value = "id") Long id) {
        return categoriaService.listarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "id") Long id) {
        return categoriaService.deletar(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Long id, @RequestBody CategoriaDto categoria) {
        return categoriaService.atualizar(id, categoria);
    }
}
