package com.test.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;


public class DataAccessImpl {

    EntityManager em;

    Logger LOGGER = LoggerFactory.getLogger(DataAccessImpl.class);




    public DataAccessImpl(EntityManager em){
        LOGGER.info("Running Entity");
        this.em = em;

    }

    public List getData(String name){
        return em.createQuery(
                "SELECT c FROM Member c WHERE c.name LIKE :custName")
                .setParameter("custName", name)
                .getResultList();
    }

}
