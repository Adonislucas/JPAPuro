package br.com.alura.loja.testes;


import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();

        Produto celular = new Produto();
        celular.setNome("Iphone");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

       


        em.getTransaction().begin();

        em.persist(celular);


        em.getTransaction().commit();
        em.close();





    }
}