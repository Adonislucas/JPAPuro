package br.com.alura.loja.vo;

import java.time.LocalDate;

public class RelatorioVendasVo {

    private String nomeProduto;
    private Integer quantidadeVendida;
    private LocalDate dataUltimaVenda;


    @Override
    public String toString() {
        return "RelatorioVendasVo{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", quantidadeVendida=" + quantidadeVendida +
                ", dataUltimaVenda=" + dataUltimaVenda +
                '}';
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    public RelatorioVendasVo(String nomeProduto, Integer quantidadeVendida, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.dataUltimaVenda = dataUltimaVenda;
    }
}
