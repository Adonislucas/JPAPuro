package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ClienteDAO {

    EntityManager em;

    public ClienteDAO(EntityManager em) {

        this.em = em;
    }

    public void cadastrarCliente (Cliente c){

        this.em.persist(c);
    }

    public Cliente buscarPorId(Long id){

        return em.find(Cliente.class, id);
    }


}
