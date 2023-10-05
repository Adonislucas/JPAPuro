package br.com.alura.loja.testes;

import br.com.alura.loja.dao.*;
import br.com.alura.loja.modelo.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Scanner;

import static br.com.alura.loja.util.JPAUtil.getEntityManager;

public class CadastroDePedido {

    public static void main(String[] args) {



        populaBD();
        EntityManager em = getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);


        Produto produto = produtoDAO.buscarPorId(1L);
        Cliente cliente = clienteDAO.buscarPorId(1L);

        em.getTransaction().begin();



        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10 , produto, pedido));

        PedidoDAO pedidoDAO = new PedidoDAO(em);

        pedidoDAO.cadastrarPedido(pedido);


        em.getTransaction().commit();
        em.close();







    }




    private static void populaBD() {
        Cliente cliente = new Cliente("Rodrigo", "123456");
        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Xiaomi", "muito legal", new BigDecimal("400"), celulares);

        EntityManager em = getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);


        em.getTransaction().begin();

        clienteDAO.cadastrarCliente(cliente);
        categoriaDAO.cadastrarCategoria(celulares);
        produtoDAO.cadastrarProduto(celular);

        em.getTransaction().commit();


        em.close();
    }

}
