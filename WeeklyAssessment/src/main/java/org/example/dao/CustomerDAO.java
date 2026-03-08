package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Customer;
import org.example.util.JPAUtil;

import java.util.List;

public class CustomerDAO {
    EntityManager em = JPAUtil.getEntityManager();

    public void insertCustomer(Customer customer){
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    public void updateCustomer(Customer customer){
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }

    public void deleteCustomer(int id){
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, id);
        if(customer!=null)
            em.remove(customer);
        em.getTransaction().commit();
    }

    public Customer getCustomerById(int id){
        em.getTransaction().begin();
        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers(){
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    //JPQL Query for fetching customer details by using email
    public Customer getCustomerByEmail(String email){
        //I used TypedQuery for implementing type safety -> normal Query can also be used
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
