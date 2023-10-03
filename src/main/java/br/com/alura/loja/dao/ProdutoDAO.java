package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em){
        this.em=em;

    }

    public void cadastrarProduto(Produto produto){

        this.em.persist(produto);
    }









}