package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {

    private EntityManager em;

    public PedidoDAO(EntityManager em) {

        this.em = em;
    }


    public void cadastrarPedido(Pedido pedido){

        this.em.persist(pedido);
    }


    public BigDecimal valorTotalVendido(){
        String jpql="SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }


   public List<RelatorioVendasVo> relatorioDeVendas(){
       String jpql = "SELECT new br.com.alura.loja.vo.RelatorioVendasVo("
               + "produto.nome, "
               + "SUM(item.quantidade), "
               + "MAX(pedido.data)) "
               + "FROM Pedido pedido "
               + "JOIN pedido.itens item "
               + "JOIN item.produto produto "
               + "GROUP BY produto.nome "
               + "ORDER BY SUM(item.quantidade) DESC";
        return em.createQuery(jpql, RelatorioVendasVo.class)
        .getResultList();

    }




}
