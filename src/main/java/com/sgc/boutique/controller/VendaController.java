package com.sgc.boutique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgc.boutique.domain.Venda;
import com.sgc.boutique.dto.RelatorioVendaDTO;
import com.sgc.boutique.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	@Autowired
    private VendaService service;

    @GetMapping
    public List<Venda> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Venda buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Venda salvar(@RequestBody Venda venda) {
        return service.salvar(venda);
    }

    @PutMapping("/{id}")
    public Venda atualizar(@PathVariable Long id,@RequestBody Venda venda) {
        return service.atualizar(id, venda);
    }
    
    @GetMapping("/relatorio")
    public RelatorioVendaDTO relatorio() {
        return service.gerarRelatorio();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
    
    @GetMapping("/cliente/{clienteId}")
    public List<Venda> vendasCliente(
            @PathVariable Long clienteId){

        return service.vendasPorCliente(clienteId);
    }
}

