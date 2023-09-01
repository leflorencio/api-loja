package com.br.cruzvita.service;

import com.br.cruzvita.dto.CategoriaDto;
import com.br.cruzvita.model.CategoriaModel;
import com.br.cruzvita.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository repository;

    @Override
    public ResponseEntity<Object> cadastrar(CategoriaDto categoria) {
        try {
            CategoriaModel categoriaModel = new CategoriaModel();
            if (repository.existsByNome(categoria.getNome())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("A categoria já está cadastrado");
            } else {
                categoriaModel.setNome(categoria.getNome());
                repository.save(categoriaModel);
                return ResponseEntity.status(HttpStatus.CREATED).body("Categoria cadastrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro");
        }
    }

    @Override
    public ResponseEntity<?> listarTodos(Pageable pageable) {
        try {
            Page<CategoriaModel> categoriaModels = repository.findAll(pageable);
            if (categoriaModels.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não localizada");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaModels);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @Override
    public ResponseEntity<?> listarPorId(Long id) {
        try {
            if (repository.existsById(id)) {
                Optional<CategoriaModel> categoria = repository.findById(id);
                return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não localizada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @Override
    public ResponseEntity<Object> deletar(Long id) {
        try {
            if (repository.existsById(id)) {
                Optional<CategoriaModel> categoria = repository.findById(id);
                CategoriaModel categoriaModel = categoria.get();
                repository.delete(categoriaModel);
                return ResponseEntity.status(HttpStatus.OK).body("Categoria excluída");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não localizada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @Override
    public ResponseEntity<Object> atualizar(Long id, CategoriaDto categoria) {
        try {
            if (repository.existsById(id)) {
                Optional<CategoriaModel> categoriaOptional = repository.findById(id);
                CategoriaModel categoriaModel = categoriaOptional.get();
                categoriaModel.setNome(categoria.getNome());
                repository.save(categoriaModel);
                return ResponseEntity.status(HttpStatus.CREATED).body("Categoria atualizada");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não localizada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }


}
