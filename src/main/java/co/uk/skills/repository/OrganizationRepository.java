package co.uk.skills.repository;

import co.uk.skills.entity.Customer;
import co.uk.skills.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
