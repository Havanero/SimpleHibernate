package com.test;


import com.test.dao.DataAccessImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

public class MainClass {

    Logger LOGGER = LoggerFactory.getLogger(MainClass.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
    EntityManager em = emf.createEntityManager();
    DataAccessImpl dataAccess = new DataAccessImpl(em);

    public static void main(String args[]){
        System.out.println("started");
        MainClass mainclass = new MainClass();
        for (Object o : mainclass.dataAccess.getData("John Smith")) {
            Member m = (Member) o;

            System.out.println("CHECKING  " + m.getName() + " " + m.getEmail() + " " + m.phone_number);


        }


        System.out.println("Done Loading");
        System.exit(0);

    }
}
