package view;

import entities.Customer;

public class App {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setMail("test@patika.dev");
        customer.setName("Test");
    }
}
