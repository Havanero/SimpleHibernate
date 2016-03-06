package com.test;


import com.test.dao.DataAccessImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainClass {

    static Logger LOGGER = LoggerFactory.getLogger(MainClass.class);
    DataAccessImpl dataAccess;
    EntityManagerFactory emf;
    EntityManager em;

    public MainClass() throws IOException {
        Properties props = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("tools.properties");
        props.load(is);
        emf = Persistence.createEntityManagerFactory("primary", props);
        em = emf.createEntityManager();
        dataAccess = new DataAccessImpl(em);
    }




    public static void main(String args[]) {
        System.out.println("started");
        MainClass mainclass = null;
        try {
            mainclass = new MainClass();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert mainclass != null;
        for (Object o : mainclass.dataAccess.getData("John Smith")) {
            Member m = (Member) o;

            LOGGER.info("CHECKING  " + m.getName() + " " + m.getEmail() + " " + m.phone_number);


        }

       /* Member m = mainclass.dataAccess.addNewMember(
                "John Smith", "xxxx@gmail.com", "0020020202"
        );
        LOGGER.info(m.toString() + " Added");*/
        System.out.println("Done Loading");
        mainclass.emf.close();



    }
}
