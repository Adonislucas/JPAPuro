package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

public class ClienteDAO {

    EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }
}
