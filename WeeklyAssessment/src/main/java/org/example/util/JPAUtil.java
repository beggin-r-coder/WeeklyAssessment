package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//I made this class for code reusability rather than calling the EntityManager factory repetitively we can use this class for easier execution.
public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer_PU");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
