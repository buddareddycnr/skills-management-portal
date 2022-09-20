package co.uk.skills.dao.impl;

import co.uk.skills.dao.AddressDao;
import co.uk.skills.entity.CustomerAddress;
import co.uk.skills.exception.CustomerNotFoundException;
import co.uk.skills.exception.SaveOrUpdateOperationFailedException;
import co.uk.skills.repository.CustomerAddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressDaoImpl implements AddressDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressDaoImpl.class);
    private CustomerAddressRepository addressRepository;

    @Autowired
    public AddressDaoImpl(CustomerAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public CustomerAddress createOrUpdateAddress(CustomerAddress address) {
        try {
            return addressRepository.save(address);
        }catch (Exception exception){
            LOGGER.error("Exception occurred while persisting customer address data {}",exception);
            throw new SaveOrUpdateOperationFailedException("Customer address save or update failed",exception);
        }
    }

    @Override
    public List<CustomerAddress> getAddressByCustomerId(long customerId) {
        try {
            return addressRepository.findById(customerId);
        }catch (Exception exception){
            LOGGER.error("Exception occurred while fetching customer address by customer Id data {}",exception);
            throw new CustomerNotFoundException("Customer address not found for the specific customer id",exception);
        }
    }
}
