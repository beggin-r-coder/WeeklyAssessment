package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Order;
import org.example.util.JPAUtil;

public class OrderDAO {
    EntityManager em = JPAUtil.getEntityManager();

    public void updateOrder(Order order){
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }

    public Order getOrder(int id){
        return em.find(Order.class, id);
    }
}
