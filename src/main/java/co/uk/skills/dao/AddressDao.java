package co.uk.skills.dao;

import co.uk.skills.entity.CustomerAddress;

import java.util.List;
import java.util.Optional;

public interface AddressDao {
    CustomerAddress createOrUpdateAddress(CustomerAddress address);
    List<CustomerAddress> getAddressByCustomerId(long customerId);
}
