package org.example;

import org.example.dao.CustomerDAO;
import org.example.model.Customer;
import org.example.model.Order;

import java.time.LocalDate;

public class App
{
    public static void main(String[]args){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer("Anishka", "anishkadas@gmail.com", "Male", 9854632718L, LocalDate.now());
        Order order = new Order("ORD101", "MacBook", 1, 93000, LocalDate.now());

        //This is the bidirectional relationship
        customer.setOrder(order);
        order.setCustomer(customer);

        //Inserting customer details
        customerDAO.insertCustomer(customer);

        //Fetching Customer using id
        Customer c = customerDAO.getCustomerById(1);
        System.out.println(c.getCustomerName());

        //Fetching Customer by Email
        Customer c_email = customerDAO.getCustomerByEmail("anishkadas@gmail.com");
        System.out.println(c_email.getCustomerName());

    }
}
