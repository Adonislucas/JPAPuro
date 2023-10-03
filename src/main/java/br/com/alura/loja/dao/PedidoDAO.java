package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

public class PedidoDAO {

    EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }



}
