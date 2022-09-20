package co.uk.skills.service.impl;

import co.uk.skills.dao.CustomerDao;
import co.uk.skills.entity.Customer;
import co.uk.skills.entity.CustomerAddress;
import co.uk.skills.exception.*;
import co.uk.skills.service.CustomerService;
import co.uk.skills.util.MandatoryFieldsLengthValidator;
import co.uk.skills.validation.EmailValidator;
import co.uk.skills.validation.FieldsValidator;
import co.uk.skills.validation.MobileNumberValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    @Value("${skill.management.portal.mobileNumber.pattern}")
    private String mobileNumberFormat;

    @Value(("${skill.management.portal.emailId.pattern}"))
    private String emailPattern;
    private MandatoryFieldsLengthValidator<Customer> mandatoryFieldsLengthValidator;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, MandatoryFieldsLengthValidator<Customer> mandatoryFieldsLengthValidator) {
        this.customerDao = customerDao;
        this.mandatoryFieldsLengthValidator = mandatoryFieldsLengthValidator;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public Customer saveOrUpdate(Customer customer) {
        if (mandatoryFieldsLengthValidator.isValidInput(customer)) {
            if (!EmailValidator.isValidEmailFormat(customer.getEmailId(),emailPattern)) {
                throw new InvalidEmailIdPatternException("Email id should in valid format");
            }
            try {
                return customerDao.createOrUpdateCustomer(customer);
            } catch (Exception exception) {
                throw new SaveOrUpdateOperationFailedException("Unable to save customer details", exception);
            }
        } else {
            throw new MandatoryFieldMissingException("Mandatory Fields are missing, Please cross verify input fields");
        }
    }

    /**
     * @return
     */
    @Override
    public List<Customer> retrieveAll() {
        return customerDao.getAllCustomers();
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public Customer getCustomerById(long customerId) {
        if(mandatoryFieldsLengthValidator.isValidLong(customerId)){
            return customerDao.getCustomerById(customerId).orElseThrow(()-> new CustomerNotFoundException("Customer details not exist in the table"));
        }
        throw new MandatoryFieldMissingException("Customer id should be valid should not be a zero");
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public String deleteCustomer(long customerId) {
        if (mandatoryFieldsLengthValidator.isValidLong(customerId)){
            return customerDao.deleteCustomer(customerId).get();
        }else {
            throw new MandatoryFieldMissingException("Valid customer id should be passed");
        }
    }

}
