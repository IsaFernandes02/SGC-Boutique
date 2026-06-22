package com.sgc.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgc.boutique.domain.Venda;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	List<Venda> findByClienteId(Long clienteId);

}
