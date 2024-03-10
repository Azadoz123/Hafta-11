package org.example.view;

import org.example.business.concretes.CustomerManager;
import org.example.core.HibernateSession;
import org.example.dao.concretes.CustomerDao;
import org.example.entities.Customer;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(new CustomerDao());

        /*Customer customer = new Customer();
        customer.setName("Spring Dersleri");
        customer.setMail("info2@patika.dev");
        customer.setGender(Customer.GENDER.MALE);
        customer.setOnDate(LocalDate.now());

        customerManager.save(customer);*/
    //    customerManager.create();

      //  customerManager.deleteById(2);
     //   System.out.println(firstCustomer.toString());

        List<Customer> customerList = customerManager.findAll();
        for (Customer customer : customerList){
            System.out.println(customer.toString());
        }

    }
}
