package com.example.produtos.repository;

import com.example.produtos.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
}
