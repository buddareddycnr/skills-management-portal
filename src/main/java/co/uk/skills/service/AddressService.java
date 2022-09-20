package co.uk.skills.service;

import co.uk.skills.entity.CustomerAddress;

import java.util.List;

public interface AddressService {
    CustomerAddress save(CustomerAddress address);
    List<CustomerAddress> getAddressByCustomerId(long customerId);
    CustomerAddress updateAddress(CustomerAddress address);
}
