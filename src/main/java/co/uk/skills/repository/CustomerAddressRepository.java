package co.uk.skills.repository;

import co.uk.skills.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long> {
    List<CustomerAddress> findById(long id);
}
