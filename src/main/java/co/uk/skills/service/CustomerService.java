package co.uk.skills.service;

import co.uk.skills.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveOrUpdate(Customer customer);
    List<Customer> retrieveAll();
    Customer getCustomerById(long customerId);
    String deleteCustomer(long customerId);
}
