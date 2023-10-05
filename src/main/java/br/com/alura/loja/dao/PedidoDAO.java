package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class PedidoDAO {

    private EntityManager em;

    public PedidoDAO(EntityManager em) {

        this.em = em;
    }


    public void cadastrarPedido(Pedido pedido){

        this.em.persist(pedido);
    }

}
