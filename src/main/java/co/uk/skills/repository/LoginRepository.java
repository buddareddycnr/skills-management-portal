package co.uk.skills.repository;

import co.uk.skills.entity.Customer;
import co.uk.skills.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {
    Optional<Login> findByUsernameAndPassword(String userName, String password);
}
