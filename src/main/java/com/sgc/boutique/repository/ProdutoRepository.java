package com.sgc.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgc.boutique.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}