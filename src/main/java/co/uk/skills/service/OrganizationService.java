package co.uk.skills.service;

import co.uk.skills.entity.Customer;
import co.uk.skills.entity.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationService {
    Organization saveOrUpdateOrganization(Organization organization);
    List<Organization> getAllOrganization();
    List<Customer> getAllCustomersByOrganizationId(long organizationId);
   String deleteOrganization(long organizationId);
}
