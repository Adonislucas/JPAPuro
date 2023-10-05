package br.com.alura.loja.testes;

import br.com.alura.loja.dao.*;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.vo.RelatorioVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static br.com.alura.loja.util.JPAUtil.getEntityManager;

public class CadastroDePedido {

    public static void main(String[] args) {


        populaBD();
        populaBD();


        EntityManager em = getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);


        Produto produto = produtoDAO.buscarPorId(1);
        Produto produto2 = produtoDAO.buscarPorId(2);
        Produto produto3 = produtoDAO.buscarPorId(3);
        Cliente cliente = clienteDAO.buscarPorId(1L);

        em.getTransaction().begin();



        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10 , produto, pedido));
        pedido.adicionarItem(new ItemPedido(20 , produto2, pedido));

        Pedido pedido2 = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(50 , produto, pedido));
        pedido.adicionarItem(new ItemPedido(30 , produto3, pedido));


        PedidoDAO pedidoDAO = new PedidoDAO(em);

        pedidoDAO.cadastrarPedido(pedido);
        pedidoDAO.cadastrarPedido(pedido2);


        em.getTransaction().commit();

        BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
        System.out.println(totalVendido);
        List<RelatorioVendasVo> relatorio =pedidoDAO.relatorioDeVendas();
        relatorio.forEach(System.out :: println);
        em.close();









    }




    private static void populaBD() {

        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");



        Produto celular = new Produto("Xiaomi", "muito legal", new BigDecimal("800"), celulares);
        Produto videogame = new Produto("PS5", "Ultima geração", new BigDecimal("2000"), videogames);
        Produto macbook = new Produto("Macbook", "Computador atualizado", new BigDecimal("1500"), informatica);


        Cliente cliente1 = new Cliente("Rodrigo", "1123456");
        Cliente cliente2 = new Cliente("Adonis", "3220598");



        EntityManager em = getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);


        em.getTransaction().begin();

        clienteDAO.cadastrarCliente(cliente1);
        clienteDAO.cadastrarCliente(cliente2);
        categoriaDAO.cadastrarCategoria(celulares);
        categoriaDAO.cadastrarCategoria(informatica);
        categoriaDAO.cadastrarCategoria(videogames);

        produtoDAO.cadastrarProduto(celular);
        produtoDAO.cadastrarProduto(videogame);
        produtoDAO.cadastrarProduto(macbook);

        em.getTransaction().commit();


        em.close();
    }

}
