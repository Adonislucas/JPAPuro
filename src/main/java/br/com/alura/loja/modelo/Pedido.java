package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private Long id;
    private LocalDate data = LocalDate.now();
    @ManyToOne
    private Cliente cliente;
    private BigDecimal valorTotal;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente ) {
        this.cliente = cliente;

    }

    public Pedido() {

    }

    public void adicionarItem(ItemPedido item) {
        item.setPedido(this);
        this.itens.add(item); 
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor_total() {
        return valorTotal;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valorTotal = valor_total;
    }

}
