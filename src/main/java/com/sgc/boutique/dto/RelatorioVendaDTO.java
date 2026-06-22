package com.sgc.boutique.dto;

public class RelatorioVendaDTO {
	
	private Long quantidadeVendas;
    private Double faturamentoTotal;
    private Double ticketMedio;

    public RelatorioVendaDTO(Long quantidadeVendas, Double faturamentoTotal, Double ticketMedio) {

        this.quantidadeVendas = quantidadeVendas;
        this.faturamentoTotal = faturamentoTotal;
        this.ticketMedio = ticketMedio;
    }

    public Long getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(Long quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }

    public Double getFaturamentoTotal() {
        return faturamentoTotal;
    }

    public void setFaturamentoTotal(Double faturamentoTotal) {
        this.faturamentoTotal = faturamentoTotal;
    }

    public Double getTicketMedio() {
        return ticketMedio;
    }

    public void setTicketMedio(Double ticketMedio) {
        this.ticketMedio = ticketMedio;
    }

}
