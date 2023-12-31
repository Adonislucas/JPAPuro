package br.com.alura.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em){
        this.em=em;

    }

    public void cadastrarProduto(Produto produto){

        this.em.persist(produto);
    }

    public Produto buscarPorId(Integer id){

        return em.find(Produto.class, id);
    }
    public void atualizarProduto(Produto produto){

        this.em.merge(produto);
    }

    public void removerProduto(Produto produto){
        produto = this.em.merge(produto);
        this.em.remove(produto);
    }

    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public List<Produto> buscarPorCategoria(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";
        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }


    public BigDecimal buscarPrecoNome (String nome){
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter(1, nome)
                .getSingleResult();
    }



    public List<Produto> buscarPorParametro(String nome, BigDecimal preco, LocalDate dataCadastro){
      CriteriaBuilder builder = em.getCriteriaBuilder();
     CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
     Root<Produto> from = query.from(Produto.class);


     Predicate filtros = builder.and();
     if(nome != null && !nome.trim().isEmpty()){
         filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));

     }
     if(preco != null ){
         filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
     }
     if(dataCadastro != null ){
         filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
        }
     query.where(filtros);

     return em.createQuery(query).getResultList();



    }

}



