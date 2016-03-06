package com.test.dao;

import com.test.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import java.util.List;


@NamedQuery(name ="getMember", query = "")
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

    public Member addNewMember(String  name, String email, String phone_number){
        Member u = new Member();
        u.setName(name);
        u.setEmail(email);
        u.setPhone_number(phone_number);
        em.getTransaction().begin();
        em.persist(u); //em.merge(u); for updates
        em.getTransaction().commit();
        em.close();

        return u;
    }


}
