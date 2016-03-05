package com.test;


import com.test.dao.DataAccessImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

   static Logger LOGGER = LoggerFactory.getLogger(MainClass.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
    EntityManager em = emf.createEntityManager();
    DataAccessImpl dataAccess = new DataAccessImpl(em);

    public static void main(String args[]) {
        System.out.println("started");
        MainClass mainclass = new MainClass();
        for (Object o : mainclass.dataAccess.getData("John Smith")) {
            Member m = (Member) o;

            LOGGER.info("CHECKING  " + m.getName() + " " + m.getEmail() + " " + m.phone_number);


        }

        Member m = mainclass.dataAccess.addNewMember(
                "John Smith", "xxxx@gmail.com", "0020020202"
        );
        LOGGER.info(m.toString() + " Added");
        System.out.println("Done Loading");
        System.exit(0);

    }
}
