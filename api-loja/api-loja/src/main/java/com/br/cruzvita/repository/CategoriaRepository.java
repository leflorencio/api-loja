package com.br.cruzvita.repository;

import com.br.cruzvita.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    boolean existsByNome(String nome);
}
