package co.uk.skills.service.impl;

import co.uk.skills.dao.CustomerDao;
import co.uk.skills.dao.OrganizationDao;
import co.uk.skills.entity.Customer;
import co.uk.skills.entity.Organization;
import co.uk.skills.exception.*;
import co.uk.skills.service.OrganizationService;
import co.uk.skills.util.MandatoryFieldsLengthValidator;
import co.uk.skills.validation.EmailValidator;
import co.uk.skills.validation.MobileNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Value("${skill.management.portal.mobileNumber.pattern}")
    private String mobileNumberFormat;
    @Value(("${skill.management.portal.emailId.pattern}"))
    private String emailPattern;
    private OrganizationDao organizationDao;
    private CustomerDao customerDao;
    private MandatoryFieldsLengthValidator<Organization> mandatoryFieldsLengthValidator;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao,CustomerDao customerDao,MandatoryFieldsLengthValidator<Organization> mandatoryFieldsLengthValidator) {
        this.organizationDao = organizationDao;
        this.mandatoryFieldsLengthValidator = mandatoryFieldsLengthValidator;
        this.customerDao = customerDao;
    }

    /**
     * @param organization
     * @return
     */
    @Override
    public Organization saveOrUpdateOrganization(Organization organization) {
        if (mandatoryFieldsLengthValidator.isValidInput(organization)) {
            if (!EmailValidator.isValidEmailFormat(organization.getEmailId(),emailPattern)) {
                throw new InvalidEmailIdPatternException("Email id should in valid format in organization");
            }
            return organizationDao.saveOrUpdateOrganization(organization);

        } else {
            throw new MandatoryFieldMissingException("Mandatory Fields are missing, Please cross verify input fields");
        }
    }

    /**
     * @return
     */
    @Override
    public List<Organization> getAllOrganization() {
       return organizationDao.getAllOrganization();
    }

    /**
     * @param organizationId
     * @return
     */
    @Override
    public List<Customer> getAllCustomersByOrganizationId(long organizationId) {
        if(mandatoryFieldsLengthValidator.isValidLong(organizationId)){
            return customerDao.getAllCustomersByOrganizationId(organizationId);
        }else {
            throw new CustomerNotFoundException(("No customers found for this organization Id"));
        }
    }


    /**
     * @param organizationId
     * @return
     */
    @Override
    public String deleteOrganization(long organizationId) {
        if(mandatoryFieldsLengthValidator.isValidLong(organizationId)) {
            return organizationDao.deleteOrganization(organizationId);
        }else {
            throw  new MandatoryFieldMissingException("Invalid organization id passed to delete organization record");
        }
    }
}
