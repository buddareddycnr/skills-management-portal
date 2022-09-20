package co.uk.skills.dao.impl;

import co.uk.skills.constants.ConstantMessage;
import co.uk.skills.dao.CustomerDao;
import co.uk.skills.entity.Customer;
import co.uk.skills.exception.CustomerNotFoundException;
import co.uk.skills.exception.DeleteOperationFailedException;
import co.uk.skills.exception.SaveOrUpdateOperationFailedException;
import co.uk.skills.exception.UnknownException;
import co.uk.skills.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl implements CustomerDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createOrUpdateCustomer(Customer customer) {
        try{
            return customerRepository.saveAndFlush(customer);
        }catch (Exception exception){
            LOGGER.error("Exception occurred while persisting customer data {}",exception);
            throw new SaveOrUpdateOperationFailedException("Unable to Save or update operation failed for the customer",exception);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try {
             return customerRepository.findAll();
        }catch (Exception exception){
            LOGGER.error("Exception occurred while fetching all customer details {}",exception);
            throw new UnknownException("Unable to fetch all customer details",exception);
        }
    }

    @Override
    public Optional<Customer> getCustomerById(long customerId) {
        try{
            return customerRepository.findById(customerId);
        }catch (Exception exception){
            LOGGER.error("Exception occurred while fetching customer by id {}",exception);
            throw new CustomerNotFoundException("Customer not available in table ",exception);
        }
    }
    public List<Customer> getAllCustomersByOrganizationId(long organizationId){
        try{
            return customerRepository.findByOrganizationId(organizationId);
        }catch (Exception exception){
            LOGGER.error("Exception occurred while fetching all customer by organization id details {}",exception);
            throw new CustomerNotFoundException("Customers not found",exception);
        }
    }
    @Override
    public Optional<String> deleteCustomer(long customerId) {
        try {
            customerRepository.deleteById(customerId);
            return Optional.of(ConstantMessage.DELETE_RECORD_MESSAGE_SUCCESS);
        }catch (Exception exception){
            LOGGER.error("Exception occurred while deleting the customer details {}",exception);
            throw new DeleteOperationFailedException("Delete customer operation failed by using customer id ",exception);
        }
    }
}
