package co.uk.skills.service.impl;

import co.uk.skills.dao.AddressDao;
import co.uk.skills.entity.CustomerAddress;
import co.uk.skills.exception.CustomerNotFoundException;
import co.uk.skills.exception.MandatoryFieldMissingException;
import co.uk.skills.service.AddressService;
import co.uk.skills.util.MandatoryFieldsLengthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao;
    private MandatoryFieldsLengthValidator<CustomerAddress> mandatoryFieldsLengthValidator;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao,MandatoryFieldsLengthValidator<CustomerAddress> mandatoryFieldsLengthValidator) {
        this.addressDao = addressDao;
        this.mandatoryFieldsLengthValidator = mandatoryFieldsLengthValidator;
    }

    /**
     * @param address
     * @return
     */
    @Override
    public CustomerAddress save(CustomerAddress address) {
        if(mandatoryFieldsLengthValidator.isValidInput(address)){
            return addressDao.createOrUpdateAddress(address);
        }else {
            throw new MandatoryFieldMissingException("Customer address fields are missing");
        }
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public List<CustomerAddress> getAddressByCustomerId(long customerId) {
        if (mandatoryFieldsLengthValidator.isValidLong(customerId)) {
           return addressDao.getAddressByCustomerId(customerId);
        }else {
            throw new MandatoryFieldMissingException("customer id missing to fetch customer addresses");
        }
    }

    /**
     * @param address
     * @return
     */
    @Override
    public CustomerAddress updateAddress(CustomerAddress address) {
        if(mandatoryFieldsLengthValidator.isValidInput(address)){
            return addressDao.createOrUpdateAddress(address);
        }else {
            throw new MandatoryFieldMissingException("Customer address fields are missing");
        }
    }
}
