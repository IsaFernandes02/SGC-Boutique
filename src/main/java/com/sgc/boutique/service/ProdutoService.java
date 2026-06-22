package com.sgc.boutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgc.boutique.domain.Produto;
import com.sgc.boutique.exception.PrecoInvalidoException;
import com.sgc.boutique.exception.ProdutoNaoEncontradoException;
import com.sgc.boutique.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
        		.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));
    }

    public Produto salvar(Produto produto) {
        if (produto.getPreco() < 0) {
        	throw new PrecoInvalidoException("Preço não pode ser negativo");
        }
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        Produto existente = buscarPorId(id);

        existente.setNome(produto.getNome());
        existente.setDescricao(produto.getDescricao());
        existente.setPreco(produto.getPreco());
        existente.setQuantidadeEstoque(produto.getQuantidadeEstoque());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}