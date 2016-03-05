package com.test;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class ListNames {

    private void setData() {

        Map<String, String> names = new HashMap<String, String>();

        names.put("Caleb", "Carvalho");
        names.put("Nelson", "Braga");

        for (Map.Entry<String, String> o : names.entrySet()) {
            System.out.println(o.getKey());
            System.out.println(o.getValue());

        }

        System.out.println(names.get("Caleb"));
        System.out.println(names.get("Nelson"));


    }

    @Test
    public void runMe() {
        setData();
    }
}
