package com.br.cruzvita.repository;

import com.br.cruzvita.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    boolean existsByNome(String nome);
}
