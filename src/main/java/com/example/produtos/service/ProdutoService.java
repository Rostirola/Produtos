package com.example.produtos.service;

import com.example.produtos.model.Produto;
import com.example.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Flux<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Produto> atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .flatMap(produtoExistente -> {
                    produtoExistente.setNome(produtoAtualizado.getNome());
                    produtoExistente.setPreco(produtoAtualizado.getPreco());
                    return produtoRepository.save(produtoExistente);
                });
    }

    public Mono<Void> deletarProduto(Long id) {
        return produtoRepository.deleteById(id);
    }
}
