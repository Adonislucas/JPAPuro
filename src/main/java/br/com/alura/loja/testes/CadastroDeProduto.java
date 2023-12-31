package br.com.alura.loja.testes;


import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static br.com.alura.loja.util.JPAUtil.getEntityManager;

public class CadastroDeProduto {
    public static void main(String[] args) {


        EntityManager em = getEntityManager();

        ProdutoDAO produtoDAO = new ProdutoDAO(em);


        Produto p = produtoDAO.buscarPorId(1);
        System.out.println(p.getPreco());
        List<Produto> nome = produtoDAO.buscarPorCategoria("Celulares");
        nome.forEach(p2 -> System.out.println(p.getNome()));








    }






    private static void CadastrarProduto() {
        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("iphone", "muito legal", new BigDecimal("800"), celulares);

        EntityManager em = getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);


        em.getTransaction().begin();
        categoriaDAO.cadastrarCategoria(celulares);
        produtoDAO.cadastrarProduto(celular);

        em.getTransaction().commit();


        em.close();
    }
}