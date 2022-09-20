package co.uk.skills.dao.impl;

import co.uk.skills.constants.ConstantMessage;
import co.uk.skills.dao.OrganizationDao;
import co.uk.skills.entity.Customer;
import co.uk.skills.entity.Organization;
import co.uk.skills.entity.OrganizationAddress;
import co.uk.skills.exception.DeleteOperationFailedException;
import co.uk.skills.exception.SaveOrUpdateOperationFailedException;
import co.uk.skills.exception.UnknownException;
import co.uk.skills.repository.OrganizationAddressRepository;
import co.uk.skills.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrganizationDaoImpl implements OrganizationDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationDaoImpl.class);
    private OrganizationRepository organizationRepository;
    private OrganizationAddressRepository organizationAddressRepository;

    @Autowired
    public OrganizationDaoImpl(OrganizationRepository organizationRepository,OrganizationAddressRepository organizationAddressRepository) {
        this.organizationRepository = organizationRepository;
        this.organizationAddressRepository = organizationAddressRepository;
    }

    /**
     * @param organization
     * @return
     */
    @Override
    public Organization saveOrUpdateOrganization(Organization organization) {
        try {
            return organizationRepository.saveAndFlush(organization);
        } catch (Exception exception) {
            LOGGER.error("Unable persist organization record {}",exception);
            throw new SaveOrUpdateOperationFailedException("Unable to save organization details ", exception);
        }
    }

    /**
     * @return
     */
    @Override
    public List<Organization> getAllOrganization() {
        try {
            return organizationRepository.findAll();
        }catch (Exception exception){
            LOGGER.error("Exception occurred while persisting customer data",exception);
            throw new UnknownException("Not able to find the organization ");
        }
    }

    /**
     * @param organizationId
     * @return
     */
    @Override
    public String deleteOrganization(long organizationId) {
        try {
            organizationRepository.deleteById(organizationId);
            return ConstantMessage.DELETE_RECORD_MESSAGE_SUCCESS;
        }catch (Exception exception){
            LOGGER.error("Exception occurred while persisting customer data",exception);
            throw new DeleteOperationFailedException("Unable to delete organization details ",exception);
        }
    }
}
