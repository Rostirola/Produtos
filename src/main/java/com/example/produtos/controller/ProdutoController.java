package com.example.produtos.controller;

import com.example.produtos.model.Produto;
import com.example.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public Flux<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Produto> criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/{id}")
    public Mono<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletarProduto(@PathVariable Long id) {
        return produtoService.deletarProduto(id);
    }
}
