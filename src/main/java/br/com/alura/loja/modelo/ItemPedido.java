package br.com.alura.loja.modelo;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal precoUnitario;
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    public ItemPedido(){}
    public ItemPedido(Integer quantidade, Produto produto, Pedido pedido) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario=produto.getPreco();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }


    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getValor(){
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }

}


