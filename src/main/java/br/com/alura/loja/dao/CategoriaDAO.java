package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em){
        this.em=em;

    }

    public void cadastrarCategoria(Categoria categoria){

        this.em.persist(categoria);
    }

    public void atualizarCategoria(Categoria categoria){
         this.em.merge(categoria);
    }
    public void deletarCategoria(Categoria categoria){
       categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }











}
