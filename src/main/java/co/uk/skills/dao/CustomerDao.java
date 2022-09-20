package co.uk.skills.dao;

import co.uk.skills.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
   Customer createOrUpdateCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(long customerId);
    Optional<String> deleteCustomer(long customerId);

    List<Customer> getAllCustomersByOrganizationId(long organizationId);
}
