package com.sgc.boutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgc.boutique.domain.Produto;
import com.sgc.boutique.domain.Venda;
import com.sgc.boutique.dto.RelatorioVendaDTO;
import com.sgc.boutique.repository.ProdutoRepository;
import com.sgc.boutique.repository.VendaRepository;

@Service
public class VendaService {
	
	 @Autowired
	    private VendaRepository repository;
	 
	 @Autowired
	 private ProdutoRepository produtoRepository;

	    public List<Venda> listarTodas() {
	        return repository.findAll();
	    }

	    public Venda buscarPorId(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Venda salvar(Venda venda) {
	    	
	    	if(venda.getItens() == null ||
	    	   venda.getItens().isEmpty()) {

	    	   throw new RuntimeException(
	    			   "A venda deve possuir ao menos um item");
	    	}

	        double total = 0.0;

	        if (venda.getItens() != null) {

	            for (var item : venda.getItens()) {

	                System.out.println("Produto ID recebido: " +
	                        item.getProduto().getId());

	                Produto produto = produtoRepository
	                        .findById(item.getProduto().getId())
	                        .orElseThrow(() ->
	                                new RuntimeException("Produto não encontrado"));

	                System.out.println("Estoque antes: " +
	                        produto.getQuantidadeEstoque());

	                
	                if(produto.getQuantidadeEstoque() < item.getQuantidade()) {

	                    throw new RuntimeException(
	                            "Estoque insuficiente para o produto "
	                            + produto.getNome());
	                }
	                
	                produto.setQuantidadeEstoque(
	                        produto.getQuantidadeEstoque()
	                        - item.getQuantidade()
	                );

	                System.out.println("Estoque depois: " +
	                        produto.getQuantidadeEstoque());

	                produtoRepository.save(produto);

	                item.setVenda(venda);

	                total += item.getQuantidade() * item.getPreco();
	            }
	        }

	        venda.setValorTotal(total);

	        return repository.save(venda);
	    }

	    public Venda atualizar(Long id, Venda venda) {

	        venda.setId(id);

	        double total = 0.0;

	        if (venda.getItens() != null) {

	            for (var item : venda.getItens()) {
	                total += item.getQuantidade() * item.getPreco();
	            }

	        }

	        venda.setValorTotal(total);

	        return repository.save(venda);
	    }

	    public void deletar(Long id) {
	        repository.deleteById(id);
	    }
	    
	    public RelatorioVendaDTO gerarRelatorio() {

	        List<Venda> vendas = repository.findAll();

	        long quantidadeVendas = vendas.size();

	        double faturamentoTotal = vendas.stream()
	                .mapToDouble(Venda::getValorTotal)
	                .sum();

	        double ticketMedio = quantidadeVendas > 0
	                ? faturamentoTotal / quantidadeVendas
	                : 0.0;

	        return new RelatorioVendaDTO(
	                quantidadeVendas,
	                faturamentoTotal,
	                ticketMedio
	        );
	    }
	    
	    public List<Venda> vendasPorCliente(Long clienteId){

	        return repository.findByClienteId(clienteId);
	    }
}
