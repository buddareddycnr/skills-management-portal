package co.uk.skills.repository;

import co.uk.skills.entity.CustomerAddress;
import co.uk.skills.entity.OrganizationAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationAddressRepository extends JpaRepository<OrganizationAddress,Long> {
    List<CustomerAddress> findById(long customerId);
}
