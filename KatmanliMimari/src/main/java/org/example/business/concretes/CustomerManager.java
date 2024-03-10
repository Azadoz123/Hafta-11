package org.example.business.concretes;

import org.example.business.abstracts.ICustomerService;
import org.example.dao.abstracts.ICustomerDao;
import org.example.entities.Customer;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CustomerManager implements ICustomerService {
    private final ICustomerDao customerDao;

    public CustomerManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findByMail(customer.getMail());
        if(checkMailCustomer != null){
            throw new RuntimeException(customer.getMail() + " bu posta adresi daha önce eklenmiş");
        }

        this.customerDao.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerDao.findById(id);
    }

    @Override
    public void update(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findByMail(customer.getMail());
        if (checkMailCustomer != null && checkMailCustomer.getId() != customer.getId()){
            throw new RuntimeException(customer.getMail() + " bu e-posta adresi daha önce eklenmiş.");
        }

        this.customerDao.update(customer);
    }

    @Override
    public void deleteById(int id) {
        Customer customer = this.findById(id);
        this.customerDao.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDao.findAll();
    }

    public void create(){
        this.customerDao.create();
    }
}
