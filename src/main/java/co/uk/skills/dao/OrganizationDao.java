package co.uk.skills.dao;

import co.uk.skills.entity.Customer;
import co.uk.skills.entity.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationDao {
    Organization saveOrUpdateOrganization(Organization organization);
    List<Organization> getAllOrganization();
    String deleteOrganization(long organizationId);
}
