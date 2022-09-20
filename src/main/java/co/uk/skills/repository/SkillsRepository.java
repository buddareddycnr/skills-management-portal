package co.uk.skills.repository;

import co.uk.skills.entity.Customer;
import co.uk.skills.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsRepository extends JpaRepository<Skill,Long> {
    List<Skill> findById(long customerId);
    void deleteAllById(long customerId);
    int countById(long customerId);
}
